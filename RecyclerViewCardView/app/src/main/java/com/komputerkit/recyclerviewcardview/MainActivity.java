package com.komputerkit.recyclerviewcardview;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        load();
        isiData();
    }

    public void  load(){
        recyclerView = findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiData(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("Muhammad", "Sidoarjo"));
        siswaList.add(new Siswa("Fulan", "Surabaya"));
        siswaList.add(new Siswa("Siti", "Jakarta"));
        siswaList.add(new Siswa("Leli", "Bandung"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Edo", "Malang"));
        siswaList.add(new Siswa("Budi", "Palembang"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));
        siswaList.add(new Siswa("Ahmad", "Jogja"));

        adapter = new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }

    public void btnTambah(View view) {
        siswaList.add(new Siswa("AHMAD", "Jogja"));
        adapter.notifyDataSetChanged();
    }
}