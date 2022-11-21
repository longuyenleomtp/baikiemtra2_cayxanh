package com.example.bt_cuoiky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ChiTietActivity extends AppCompatActivity {
    TextView tenkh, tentg, dactinh, maula, hinhanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        tenkh = (TextView) findViewById(R.id.tenkh);
        tentg = (TextView) findViewById(R.id.tentg);
        dactinh  = (TextView) findViewById(R.id.dactinh);

        Intent intent = getIntent();
        tenkh.setText(intent.getStringExtra("ten"));
        tentg.setText(intent.getStringExtra("casi"));
        dactinh.setText(intent.getStringExtra("loi"));
        new LoadImage().execute(intent.getStringExtra("anh"));


    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmapHinh = null;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                InputStream inputStream = url.openConnection().getInputStream();

                bitmapHinh = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmapHinh;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

        }

    }
}