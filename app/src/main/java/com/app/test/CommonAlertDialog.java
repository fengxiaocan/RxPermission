package com.app.test;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created: AriesHoo on 2017-01-19 14:16
 * Function: 自定义AlertDialog 弹出提示框
 * Desc:
 */

public class CommonAlertDialog extends AlertDialog {
    private int width = WindowManager.LayoutParams.MATCH_PARENT;
    private int height = WindowManager.LayoutParams.WRAP_CONTENT;

    private CommonAlertDialog(Context context) {
        super(context);
    }

    private CommonAlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener)
    {
        super(context, cancelable, cancelListener);
    }

    private CommonAlertDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static Builder builder(Context context, int themeResId) {
        return new Builder(context, themeResId);
    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        window.setLayout(width, height);
    }

    public static class CommonDialogListener implements OnClickListener {
        public CommonDialogListener() {
        }

        public CommonDialogListener(boolean s) {
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }

    public static class Builder {
        private CommonAlertDialog dialog;

        private Builder(Context context) {
            dialog = new CommonAlertDialog(context);
        }

        private Builder(Context context, int themeResId) {
            dialog = new CommonAlertDialog(context, themeResId);
        }

        /**
         * 设置窗口透明度
         *
         * @param alpha the alpha
         * @return ios dialog
         */
        public Builder setAlpha(float alpha) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.alpha = alpha;
            window.setAttributes(params);
            return this;
        }

        /**
         * 设置背景黑暗度
         *
         * @param dimAmount the dim amount
         * @return ios dialog
         */
        public Builder setDimAmount(float dimAmount) {
            Window window = dialog.getWindow();
            window.setDimAmount(dimAmount);
            return this;
        }

        public Builder layout(int width, int height) {
            dialog.width = width;
            dialog.height = height;
            return this;
        }


        public Builder gravity(int gravity) {
            Window window = dialog.getWindow();
            window.setGravity(gravity);
            return this;
        }

        public Builder padding(int left, int top, int right, int bottom) {
            Window window = dialog.getWindow();
            window.getDecorView()
                  .setPadding(left, top, right, bottom);
            return this;
        }

        public Builder background(Drawable drawable) {
            Window window = dialog.getWindow();
            window.setBackgroundDrawable(drawable);
            return this;
        }

        public Builder background(@DrawableRes int resId) {
            Window window = dialog.getWindow();
            window.setBackgroundDrawable(dialog.getContext()
                                               .getResources()
                                               .getDrawable(resId));
            return this;
        }


        /**
         * 是否设置点击dialog区域外，dialog消失
         *
         * @param cancel the cancel
         */
        public Builder setCanceledOnTouchOutside(boolean cancel) {
            dialog.setCanceledOnTouchOutside(cancel);
            return this;
        }

        /**
         * 设置标题
         *
         * @param title the title
         * @return ios dialog
         */
        public Builder setTitle(CharSequence title) {
            dialog.setTitle(title);
            return this;
        }

        /**
         * Set title ios dialog.
         *
         * @param title the title
         * @return the ios dialog
         */
        public Builder setTitle(int title) {
            dialog.setTitle(title);
            return this;
        }

        /**
         * 设置提示语
         *
         * @param msg the msg
         * @return ios dialog
         */
        public Builder setMessage(CharSequence msg) {
            dialog.setMessage(msg);
            return this;
        }


        /**
         * 设置返回键弹框是否可消失
         *
         * @param cancel the cancel
         * @return ios dialog
         */
        public Builder setCancelable(boolean cancel) {
            dialog.setCancelable(cancel);
            return this;
        }

        /**
         * 设置左边按钮
         *
         * @param text     the text
         * @param listener the listener
         * @return ios dialog
         */
        public Builder setRightButton(CharSequence text,
                final OnClickListener listener)
        {
            dialog.setButton(BUTTON_POSITIVE, text, listener);
            return this;
        }


        /**
         * 设置左边按钮
         *
         * @param text the text
         * @return ios dialog
         */
        public Builder setRightButton(CharSequence text) {
            dialog.setButton(BUTTON_POSITIVE, text, new CommonDialogListener(true));
            return this;
        }


        /**
         * Set Middle button ios dialog.
         *
         * @param text     the text
         * @param listener the listener
         * @return the ios dialog
         */
        public Builder setLeftButton(CharSequence text,
                final OnClickListener listener)
        {
            dialog.setButton(BUTTON_NEUTRAL, text, listener);
            return this;
        }

        /**
         * Set Middle button ios dialog.
         *
         * @param text the text
         * @return the ios dialog
         */
        public Builder setLeftButton(CharSequence text) {
            dialog.setButton(BUTTON_NEUTRAL, text, new CommonDialogListener(true));
            return this;
        }


        /**
         * Set on key listener ios dialog.
         *
         * @param onKeyListener the on key listener
         * @return the ios dialog
         */
        public Builder setOnKeyListener(OnKeyListener onKeyListener)
        {
            dialog.setOnKeyListener(onKeyListener);
            return this;
        }

        /**
         * Set on dismiss listener ios dialog.
         *
         * @param onDismissListener the on dismiss listener
         * @return the ios dialog
         */
        public Builder setOnDismissListener(OnDismissListener onDismissListener)
        {
            dialog.setOnDismissListener(onDismissListener);
            return this;
        }

        /**
         * Set Right button ios dialog.
         *
         * @param text     the text
         * @param listener the listener
         * @return the ios dialog
         */
        public Builder setMiddleButton(CharSequence text,
                final OnClickListener listener)
        {
            dialog.setButton(BUTTON_NEGATIVE, text, listener);
            return this;
        }

        /**
         * Set Right button ios dialog.
         *
         * @param text the text
         * @return the ios dialog
         */
        public Builder setMiddleButton(CharSequence text) {
            dialog.setButton(BUTTON_NEGATIVE, text, new CommonDialogListener(true));
            return this;
        }


        /**
         * Show.
         */
        public CommonAlertDialog show() {
            dialog.show();
            return dialog;
        }

        /**
         * Show.
         */
        public CommonAlertDialog create() {
            return dialog;
        }

        /**
         * Dismiss.
         */
        public CommonAlertDialog dismiss() {
            dialog.dismiss();
            return dialog;
        }
    }
}
