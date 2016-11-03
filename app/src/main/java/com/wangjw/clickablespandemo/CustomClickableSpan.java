package com.wangjw.clickablespandemo;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wangjw on 16/11/3.
 */

public class CustomClickableSpan extends ClickableSpan {

    private Context mContext;
    private int mAtIndex; //@的位置

    public CustomClickableSpan(Context context, int atIndex) {
        mContext = context;
        mAtIndex = atIndex;
    }

    @Override
    public void onClick(View widget) {
        if (widget instanceof TextView) {
            TextView textView = (TextView) widget;
            Log.d("SpanContent", "Content = " + textView.getText().toString());

            String str = textView.getText().toString();
            int sIndex = str.indexOf(" ", mAtIndex); //找到@后的第一个空格
            Toast.makeText(mContext, str.substring(mAtIndex + 1, sIndex), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.BLUE);
        ds.setUnderlineText(false);
        ds.clearShadowLayer();
    }

}
