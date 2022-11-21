package com.example.bt_cuoiky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class CayXanh extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    FloatingActionButton floatingActionButton;
    CayAdapter cayAdapter;
    LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cay_xanh);

        recyclerView = (RecyclerView) findViewById(R.id.rcv_covu);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        searchView = (SearchView) findViewById(R.id.search_view);
        back = (LinearLayout) findViewById(R.id.back);
        searchView.clearFocus();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<CayXanhModel> options =
                new FirebaseRecyclerOptions.Builder<CayXanhModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Cayxanh"), CayXanhModel.class)
                        .build();
        cayAdapter = new CayAdapter(options, this);
        recyclerView.setAdapter(cayAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CayXanh.this, GiaoDienChinh.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });

    }

    protected void onStart() {
        super.onStart();
        cayAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cayAdapter.stopListening();
    }

    private void txtSearch(String str){
        FirebaseRecyclerOptions<CayXanhModel> options =
                new FirebaseRecyclerOptions.Builder<CayXanhModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("cayxanh").orderByChild("ten").startAt(str).endAt(str+"~"), CayXanhModel.class)
                        .build();
        cayAdapter = new CayAdapter(options, this);
        cayAdapter.startListening();
        recyclerView.setAdapter(cayAdapter);
    }

}