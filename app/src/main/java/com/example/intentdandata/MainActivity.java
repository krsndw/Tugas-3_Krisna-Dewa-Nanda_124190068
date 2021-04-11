package com.example.intentdandata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnDial, btnList;
    private RecyclerView rvSeries;
    private ArrayList<ClassModel> classModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.dial);
        btnList = findViewById(R.id.list);

        //dial
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dial = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:082288026599"));
                startActivity(dial);
            }
        });

        //list
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvSeries = findViewById(R.id.rv_series);
                rvSeries.setHasFixedSize(true);
                classModels.addAll(ClassData.getListData());
                showRecyclerList();
            }
        });
    }

    protected void showRecyclerList() {
        rvSeries.setLayoutManager(new LinearLayoutManager(this));
        ClassAdapter classAdapter = new ClassAdapter(this);
        classAdapter.setClassModels(classModels);
        rvSeries.setAdapter(classAdapter);
    }

}