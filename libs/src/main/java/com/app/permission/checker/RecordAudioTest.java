package com.app.permission.checker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


class RecordAudioTest implements PermissionTest {

    private static final int[] RATES = new int[]{8000, 11025, 22050, 44100};

    private final Context mContext;

    RecordAudioTest(Context context) {
        this.mContext = context;
    }

    public static boolean existMicrophone(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    public static int[] findAudioParameters() {
        for (int rate : RATES) {
            for (int channel : new int[]{AudioFormat.CHANNEL_IN_MONO, AudioFormat.CHANNEL_IN_STEREO}) {
                for (int format : new int[]{AudioFormat.ENCODING_PCM_8BIT, AudioFormat.ENCODING_PCM_16BIT}) {
                    int buffer = AudioRecord.getMinBufferSize(rate, channel, format);
                    if (buffer != AudioRecord.ERROR_BAD_VALUE) {
                        return new int[]{rate, channel, format, buffer};
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean test() throws Throwable {
        AudioRecord audioRecord = null;
        File file = null;
        FileOutputStream fos = null;
        try {
            int[] params = findAudioParameters();
            if (params == null) return !existMicrophone(mContext);

            audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, params[0], params[1], params[2], params[3]);
            int state = audioRecord.getState();
            if (state != AudioRecord.STATE_INITIALIZED) return !existMicrophone(mContext);

            int recordState = audioRecord.getRecordingState();
            if (recordState != AudioRecord.RECORDSTATE_STOPPED) return true;

            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING) return true;

            File cacheDir = new File(mContext.getCacheDir(), "_andpermission_audio_record_test_");
            cacheDir.mkdirs();

            file = new File(cacheDir, Long.toString(System.currentTimeMillis()));
            if (file.exists()) file.createNewFile();

            fos = new FileOutputStream(file);
            byte[] buffer = new byte[params[3]];

            int len = audioRecord.read(buffer, 0, params[3]);
            fos.write(buffer, 0, len);
            fos.flush();
        } catch (Throwable e) {
            return !existMicrophone(mContext);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            if (audioRecord != null) {
                audioRecord.release();
            }
        }
        return true;
    }

}