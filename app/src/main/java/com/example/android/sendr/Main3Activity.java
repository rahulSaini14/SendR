package com.example.android.sendr;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        CheckBox check = (CheckBox) findViewById(R.id.checkbox);
        Button btn1 = (Button) findViewById(R.id.submit);
        Button btn2 = (Button) findViewById(R.id.submit2);
        Button btnrst = (Button) findViewById(R.id.reset);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View rl = findViewById(R.id.relative);
                EditText editText = (EditText) findViewById(R.id.editText);
                CheckBox check = (CheckBox) findViewById(R.id.checkbox);
                boolean chk = check.isChecked();
                if (chk) {
                    rl.setBackgroundColor(Color.parseColor("#778899"));
                    editText.setBackgroundColor(Color.parseColor("#000000"));
                    editText.setTextColor(Color.parseColor("#FFFFFF"));
                    check.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if (!chk) {
                    rl.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    editText.setBackgroundColor(Color.parseColor("#FFFACD"));
                    editText.setTextColor(Color.parseColor("#000000"));
                    check.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText2 = (EditText) findViewById(R.id.editText);
                String txt = editText2.getText().toString();
                Intent sms = new Intent();
                sms.setAction(Intent.ACTION_SEND);
                sms.putExtra(Intent.EXTRA_TEXT, txt);
                sms.setPackage("com.whatsapp");
                sms.setType("text/plain");
                if (sms.resolveActivity(getPackageManager()) != null) {
                    startActivity(sms);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText3 = (EditText) findViewById(R.id.editText);
                String txt = editText3.getText().toString();
                Intent sms2 = new Intent();
                sms2.setAction(Intent.ACTION_SEND);
                sms2.putExtra(Intent.EXTRA_TEXT, txt);
                sms2.setType("text/plain");
                if (sms2.resolveActivity(getPackageManager()) != null) {
                    startActivity(sms2);
                }
            }
        });
        btnrst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText3 = (EditText) findViewById(R.id.editText);
                editText3.setText("");
            }
        });
    }
}
