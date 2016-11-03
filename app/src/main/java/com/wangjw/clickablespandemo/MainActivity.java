package com.wangjw.clickablespandemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvContent = (TextView) findViewById(R.id.TextView_Content);

        String content = "@阿里巴巴 @百度 @腾讯 真有钱!";

        layoutContent(tvContent, content);
    }

    private void layoutContent(TextView textView, String content) {
        if (!content.contains("@")) { //校验数据格式
            textView.setText(content);
            return;
        }

        SpannableStringBuilder builder = new SpannableStringBuilder(content);

        int index = 0;
        while (content.indexOf("@", index) != -1) {
            int atIndex = content.indexOf("@", index);  //@的位置
            int sIndex = content.indexOf(" ", atIndex); //空格的位置

            index = sIndex;
            if (sIndex < atIndex) { //数据格式不符合
                continue;
            }
            Log.d("ClickSpan", "@ = " + atIndex + " S = " + sIndex);

            CustomClickableSpan clickableSpan = new CustomClickableSpan(this, atIndex);
            builder.setSpan(clickableSpan, atIndex, sIndex, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(builder);
    }
}
