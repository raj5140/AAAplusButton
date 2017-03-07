package com.example.rajiv.aaaplusbutton;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";
    EditText height, width;
    Button but_add;
    ImageButton but_remove;
    TextView txtSum, zerotextView;
    LinearLayout linearBelowBoard;
    int e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearBelowBoard = (LinearLayout) findViewById(R.id.linearBelowBoard);
        txtSum = (TextView) findViewById(R.id.totalText);
        but_add = (Button) findViewById(R.id.button2);

        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);


                width = (EditText) addView.findViewById(R.id.width);
                height = (EditText) addView.findViewById(R.id.height);
                zerotextView = (TextView) addView.findViewById(R.id.zerotextView);

                width.addTextChangedListener(new MyTextWatcher(height, width, zerotextView));
                height.addTextChangedListener(new MyTextWatcher(height, width, zerotextView));


                but_remove = (ImageButton) addView.findViewById(R.id.remove);
                final View.OnClickListener thisListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                };

                but_remove.setOnClickListener(thisListener);
                linearBelowBoard.addView(addView);
            }

        });

    }

    private class MyTextWatcher implements TextWatcher {
        EditText mEditText1 = null;
        EditText mEditText2 = null;
        TextView textView = null;

        public MyTextWatcher(EditText mEditText1, EditText mEditText2, TextView textView) {
            this.textView = textView;
            this.mEditText1 = mEditText1;
            this.mEditText2 = mEditText2;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calCheck(mEditText1, mEditText2, textView);
            calCheck2(textView);
        }
    }

    public void calCheck(EditText height, EditText width, TextView zerotextView) {
        try {
            e1 = Integer.parseInt(width.getText().toString());
            e2 = Integer.parseInt(height.getText().toString());
            e3 = e1 * e2;
            zerotextView.setText(Integer.toString(e3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calCheck2(TextView textView) {
        if (linearBelowBoard != null) {
            e1 = 0;
            for (int i = 0; i < linearBelowBoard.getChildCount(); i++) {
                EditText editText1 = getEditTextFromPosition(i);
                String str = editText1.getText().toString();
                Log.d(LOG_TAG, "calCheck2: " + str);
                if (!str.isEmpty()) {
                    e1 = e1 + Integer.parseInt(editText1.getText().toString());
                }
            }
        }
        txtSum.setText(String.valueOf(e1));
    }

    private EditText getEditTextFromPosition(int position) {
        return (EditText) linearBelowBoard.getChildAt(position).findViewById(R.id.width);
    }
}