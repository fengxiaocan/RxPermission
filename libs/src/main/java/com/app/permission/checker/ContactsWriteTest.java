
package com.app.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

import com.app.permission.checker.PermissionTest;


class ContactsWriteTest implements PermissionTest {

    private static final String DISPLAY_NAME = "PERMISSION";

    private ContentResolver mResolver;

    ContactsWriteTest(ContentResolver resolver) {
        this.mResolver = resolver;
    }

    @Override
    public boolean test() throws Throwable {
        long[] idArray = insert();
        long rawContactId = idArray[0];
        long dataId = idArray[1];
        if (rawContactId > 0 && dataId > 0) {
            return delete(rawContactId, dataId);
        }
        return false;
    }

    private long[] insert() {
        ContentValues values = new ContentValues();
        Uri rawContractUri = mResolver.insert(ContactsContract.RawContacts.CONTENT_URI, values);
        long rawContactId = ContentUris.parseId(rawContractUri);

        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.DATA1, DISPLAY_NAME);
        values.put(ContactsContract.Data.DATA2, DISPLAY_NAME);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        Uri dataUri = mResolver.insert(ContactsContract.Data.CONTENT_URI, values);
        long dataId = ContentUris.parseId(dataUri);
        return new long[]{rawContactId, dataId};
    }

    private boolean delete(long rawContactId, long dataId) {
        int dataCount = mResolver.delete(ContactsContract.Data.CONTENT_URI, ContactsContract.Data._ID + "=?",
            new String[]{Long.toString(dataId)});
        int rawContactCount = mResolver.delete(ContactsContract.RawContacts.CONTENT_URI, ContactsContract.RawContacts._ID + "=?",
            new String[]{Long.toString(rawContactId)});
        return rawContactCount > 0 && dataCount > 0;
    }

    private boolean update(long rawContactId) {
        ContentValues values = new ContentValues();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.DATA1, DISPLAY_NAME);
        values.put(ContactsContract.Data.DATA2, DISPLAY_NAME);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        Uri dataUri = mResolver.insert(ContactsContract.Data.CONTENT_URI, values);
        return ContentUris.parseId(dataUri) > 0;
    }

    @Nullable
    private long[] query() {
        Cursor cursor = mResolver.query(ContactsContract.Data.CONTENT_URI,
            new String[]{ContactsContract.Data.RAW_CONTACT_ID, ContactsContract.Data._ID},
            ContactsContract.Data.MIMETYPE + "=? and " + ContactsContract.Data.DATA1 + "=?",
            new String[]{ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE, DISPLAY_NAME}, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                long rawContactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.RAW_CONTACT_ID));
                long dataId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data._ID));
                return new long[]{rawContactId, dataId};
            }
        }
        return null;
    }
}