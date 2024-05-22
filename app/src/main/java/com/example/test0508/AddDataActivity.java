package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    private TextView addName;

    private TextView addHeight;

    private TextView addUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        addName = findViewById(R.id.edAddName);
        addHeight = findViewById(R.id.edAddHeight);
        addUrl = findViewById(R.id.edaddImgURL);


    }
    public void addData (View view){
        Intent intent = new Intent();
        String name = addName.getText().toString();
        String height = addHeight.getText().toString();
        String imageUrl = addUrl.getText().toString();

        intent.putExtra("name", name);
        intent.putExtra("height", height);
        intent.putExtra("url", imageUrl);
        setResult(RESULT_OK, intent);
    }
}