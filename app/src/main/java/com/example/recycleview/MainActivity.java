package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView recycler;
    private RecyclerAdapter adapter;
    EditText etAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAdd = (EditText) findViewById(R.id.etAdd);
        setupRecycleView();
        setupRecycleViewData();
    }

    private void setupRecycleView() {

        recycler = findViewById(R.id.recycleView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(this);
        recycler.setAdapter(adapter);

    }

    private void setupRecycleViewData() {
        List<String> data = new ArrayList<>();
        data.add("Sanja Lupić");

        adapter.addData(data);
    }

    public void addCell(View view) {
        String Name = etAdd.getText().toString();
        adapter.addNewCell(Name);
    }


    public void removeCell(View view) {
        adapter.removeCell(0);
    }


    @Override
    public void ClickButton(int position) {
        adapter.removeCell(position);
    }
}