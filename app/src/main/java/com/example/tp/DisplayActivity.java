package com.example.tp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity implements PostExecuteActivity<OnePieceCharacter> {

    List<OnePieceCharacter> completeList = new ArrayList<>();
    List<OnePieceCharacter> displayedList = new ArrayList<>();

    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        ListView listView = findViewById(R.id.listView);
        adapter = new ListAdapter(displayedList, getApplicationContext());
        listView.setAdapter(adapter);
        HttpAsyncGet<OnePieceCharacter> async = new HttpAsyncGet<>("http://edu.info06.net/onepiece/characters.json", OnePieceCharacter.class, this, new ProgressDialog(DisplayActivity.this));

    }

    @Override
    public void onPostExecute(List<OnePieceCharacter> itemList) {
        completeList.addAll(itemList);
        displayedList.addAll(completeList);
        adapter.notifyDataSetChanged();
    }
}