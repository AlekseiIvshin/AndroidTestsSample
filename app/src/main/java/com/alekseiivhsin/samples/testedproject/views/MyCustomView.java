package com.alekseiivhsin.samples.testedproject.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alekseiivhsin.samples.testedproject.R;

/**
 * Created on 23/11/2015.
 */
public class MyCustomView extends LinearLayout {

    private static final String DEFAULT_TEXT_1 = "Text 1";
    private static final String DEFAULT_TEXT_2 = "Text 2";

    String contentText1;
    String contentText2;

    public TextView textView1;
    public TextView textView2;

    public MyCustomView(Context context) {
        super(context);
        init(null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }
    protected void init(AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
            contentText1 = a.getString(R.styleable.MyCustomView_text1);
            contentText2 = a.getString(R.styleable.MyCustomView_text2);
            a.recycle();
        }
        if (contentText1 == null) {
            contentText1 = DEFAULT_TEXT_1;
        }
        if (contentText2 == null) {
            contentText2 = DEFAULT_TEXT_2;
        }
        inflate(getContext(), R.layout.my_custom_view, this);

        textView1 = (TextView) findViewById(R.id.text1);
        textView1.setText(contentText1);

        textView2 = (TextView) findViewById(R.id.text2);
        textView2.setText(contentText2);
    }
}
