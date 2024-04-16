package com.example.tp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class DisplayActivity extends AppCompatActivity implements Clickable, PostExecuteActivity{

    List<OnePieceCharacter> completeList;
    List<OnePieceCharacter> displayedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        HttpAsyncGet async = new HttpAsyncGet("http://edu.info06.net/onepiece/characters.json", OnePieceCharacter.class, this, new ProgressDialog(getApplicationContext()));
    }

    @Override
    public void onClicItem(int itemIndex) {
        Intent intent = new Intent(getApplicationContext(),CharacterActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("perso", displayedList.get(itemIndex));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onRatingBarChange(int itemIndex, float value) {
        displayedList.get(0).setValue(value);
    }

    @Override
    public void onPostExecute(List itemList) {
        completeList.addAll(itemList);
    }
}
