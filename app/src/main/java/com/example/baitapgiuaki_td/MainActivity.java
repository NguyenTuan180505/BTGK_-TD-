package com.example.baitapgiuaki_td;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText edtName, edtPhone;
    Spinner spinnerProgram;
    Button btnQuyenGop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        edtName = findViewById(R.id.edtName);
        spinnerProgram = findViewById(R.id.spinnerProgram);
        btnQuyenGop = findViewById(R.id.btnQuyenGop);

        spinnerProgram.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                Arrays.asList("Ủng hộ miền trung", "Gây quỹ hộ nghèo")));
        btnQuyenGop.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();
            String program = spinnerProgram.getSelectedItem().toString();
            if(name.isEmpty() || phone.isEmpty()){
                Toast.makeText(this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent i = new Intent(this, DonateActivity.class);
            i.putExtra("name",name);
            i.putExtra("phone",phone);
            i.putExtra("program",program);
            startActivityForResult(i, 100);

        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tvResult.setText(data.getStringExtra("result"));
    }
}