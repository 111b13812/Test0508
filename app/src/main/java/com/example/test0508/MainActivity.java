package com.example.test0508;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends UpdateActivity {

    private RecyclerView recyclerView;
    private List<StuData> stuDataList;
    private StuDataAdapter adapter;

    //建立一個 ActivityResultContract 可以接收 addDataActivity 的資料
    private ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result != null) {
                    Intent data = result.getData();
                    String name = data.getStringExtra("name");
                    String height = data.getStringExtra("height");
                    String url = data.getStringExtra("url");
                    Log.d("MainActivity", "name: " + name + " height: " + height + " url: " + url);
                    stuDataList.add(new StuData(url, name, height));
                    adapter.notifyDataSetChanged();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMyData);

        stuDataList = new ArrayList<>();

        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "John", "180"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Tom", "175"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Jerry", "170"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Mike", "165"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Jack", "160"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Rose", "155"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Lily", "150"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Lucy", "145"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Linda", "140"));
        stuDataList.add(new StuData("https://thumbs.dreamstime.com/b/top-view-baby-cat-kitten-white-background-36491717.jpg", "Marry", "135"));
        adapter = (StuDataAdapter) recyclerView.getAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        //startActivityForResult(intent, 1);
        activityResultLauncher.launch(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String height = data.getStringExtra("height");
            String imageUrl = data.getStringExtra("imageUrl");
            stuDataList.add(new StuData(imageUrl, name, height));
            adapter.notifyDataSetChanged();
        }
    }
}