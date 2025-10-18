package com.example.baitapgiuaki_td;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DonateActivity extends AppCompatActivity {
    TextView tvInFo;
    EditText edtMoney, editMessage;
    Button btnSend;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        tvInFo = findViewById(R.id.tvInfo);
        editMessage = findViewById(R.id.edtMessage);
        edtMoney = findViewById(R.id.edtMoney);
        btnSend = findViewById(R.id.btnQuyenGop);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String program = intent.getStringExtra("program");
        tvInFo.setText("Tên người gửi: "+name+"\nSĐT: "+phone+"\nTên Chương Trình: "+program);
        btnSend.setOnClickListener(v -> {
            String money = edtMoney.getText().toString().trim();
            String message = editMessage.getText().toString().trim();
            if(money.isEmpty()){
                Toast.makeText(this, "Vui long nhap tien", Toast.LENGTH_SHORT).show();
                return;
            }
            String result = name +", bạn đã ủng hộ "+money +"Đ cho chương trình: " +program+ "Lời nhắn : " +message;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", result);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

    }
}
