package com.example.tp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity implements  PostExecuteActivity{
    private final String TAG = "cam "+getClass().getSimpleName();
    List<OnePieceCharacter> completeList = new ArrayList<>();
    List<OnePieceCharacter> displayedList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        ListView listView = findViewById(R.id.listView);
        ListAdapter adapter = new ListAdapter(displayedList, getApplicationContext());
        listView.setAdapter(adapter);

        HttpAsyncGet async = new HttpAsyncGet("http://edu.info06.net/onepiece/characters.json", OnePieceCharacter.class, this, new ProgressDialog(getApplicationContext()));

    }


    @Override
    public void onPostExecute(List itemList) {
        OnePieceCharacter op = (OnePieceCharacter) itemList.get(0);
        Log.d(TAG,"First pokemon = " + op.getName());
        completeList.addAll(itemList);
    }
}
