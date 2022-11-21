package com.example.bt_cuoiky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText tenkh, tentg, dactinh, maula, hinhanh;
    Button btnSave, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tenkh = (EditText) findViewById(R.id.txtName);
        tentg = (EditText) findViewById(R.id.txttenthuonggoi);
        dactinh = (EditText) findViewById(R.id.txtdactinh);
        maula = (EditText) findViewById(R.id.maula);
        hinhanh = (EditText) findViewById(R.id.hinhanh);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
                startActivity(new Intent(AddActivity.this, CayXanh.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivity.this, CayXanh.class));
            }
        });

    }

    private void insertData(){
        Map<String, Object> map = new HashMap<>();
        map.put("ten", tenkh.getText().toString());
        map.put("loi", tentg.getText().toString());
        map.put("casi", dactinh.getText().toString());
        map.put("maula", maula.getText().toString());
        map.put("hinhanh", hinhanh.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("cayxanh").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Error while Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private  void clearAll(){
        tenkh.setText("");
        tentg.setText("");
        dactinh.setText("");
        maula.setText("");
        hinhanh.setText("");
    }
}