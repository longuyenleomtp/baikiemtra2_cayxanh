package com.example.bt_cuoiky;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileFragment extends Fragment {
    TextView  txtemail;
    ImageView btnLogout;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile_fragment, container, false);
        txtemail = view.findViewById(R.id.email);
        btnLogout = view.findViewById(R.id.logout_btn);

        Intent intent = getActivity().getIntent();
        String user = intent.getStringExtra("user");
        Toast.makeText(getContext(), "tai khan:"+user, Toast.LENGTH_SHORT).show();

        Cursor dataAccount = DangNhap.database.GetData("SELECT * FROM TaiKhoan");
        while (dataAccount.moveToNext()) {
            String userName = dataAccount.getString(0);
            String fullname = dataAccount.getString(2);
            String email = dataAccount.getString(3);
            String phone = dataAccount.getString(4);

            if (userName.equals(user)) {
                txtemail.setText(email);
                break;
            }
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DangNhap.class));
            }
        });


        return view;
    }
}
