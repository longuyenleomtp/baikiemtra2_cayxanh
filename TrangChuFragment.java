package com.example.bt_cuoiky;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class TrangChuFragment extends Fragment {
    GridView gridView;
    ArrayList<LoaiCay> loaiCayArrayList;
    LoaiCayAdapter cayAdapter;
    VideoView videoView;
    ImageButton imageButton;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trang_chu_fragment,container,false);
        gridView = (GridView) view.findViewById(R.id.gv_ldv);
        videoView = (VideoView) view.findViewById(R.id.videoview);
        imageButton = (ImageButton) view.findViewById(R.id.ib_play);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton.setVisibility(View.INVISIBLE);
                MediaController mc = new MediaController(getActivity());
                mc.setMediaPlayer(videoView);
                videoView.setMediaController(mc);
            }
        });
        DanhSach();
        cayAdapter = new LoaiCayAdapter(getContext(), R.layout.gridview_item, loaiCayArrayList);
        gridView.setAdapter(cayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), CayXanh.class));
            }
        });
        return view;
    }

    private void DanhSach() {
        loaiCayArrayList = new ArrayList<>();
        loaiCayArrayList.add(new LoaiCay("Cây Bonsai", R.drawable.viet));
        loaiCayArrayList.add(new LoaiCay("Cây Tùng", R.drawable.hoa));
        loaiCayArrayList.add(new LoaiCay("Cây Bằng lăng", R.drawable.han));
        loaiCayArrayList.add(new LoaiCay("Cây vạn thọ", R.drawable.aumy));
    }
}