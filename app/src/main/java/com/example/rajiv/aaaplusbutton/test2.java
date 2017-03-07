//package com.example.rajiv.aaaplusbutton;
//
//import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//
//    EditText edt1;
//    Button but_add, but_remove;
//    TextView txtSum;
//    LinearLayout linearBelowBoard;
//    int e1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        linearBelowBoard = (LinearLayout) findViewById(R.id.linearBelowBoard);
//
//        txtSum=(TextView)findViewById(R.id.totalText);
//
//
//        but_add = (Button) findViewById(R.id.button2);
//        but_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LayoutInflater layoutInflater =
//                        (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                final View addView = layoutInflater.inflate(R.layout.row, null);
//
//
//                edt1 = (EditText) addView.findViewById(R.id.editText);
//
//                edt1.addTextChangedListener(new TextWatcher() {
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before,
//                                              int count) {
//                    }
//
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count,
//                                                  int after) {
//                        if (s.length() > 0) {
//
//                        }
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//                        calCheck();
//                    }
//                });
//
//
//                Button but_remove = (Button) addView.findViewById(R.id.button);
//                final View.OnClickListener thisListener = new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ((LinearLayout) addView.getParent()).removeView(addView);
//                    }
//                };
//
//                but_remove.setOnClickListener(thisListener);
//                linearBelowBoard.addView(addView);
//
//
//            }
//
//        });
//
//    }
//
//    public void calCheck() {
//
//        try {
//            e1 = Integer.parseInt(edt1.getText().toString());
//            txtSum.setText(Integer.toString(e1));
//
//        } catch (Exception e) {
//
//        }
//
//
//    }
//}
//
//
//
//
//
