package com.example.sharedprefrencesactivitylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextMajor, editTextStudentID;
    private TextView txvName, txvMajor, txvID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextMajor = findViewById(R.id.editTextMajor);
        editTextStudentID = findViewById(R.id.editTextStudentID);

        txvName = findViewById(R.id.txvName);
        txvMajor = findViewById(R.id.txvMajor);
        txvID = findViewById(R.id.txvID);
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // save data as key value pairs
        editor.putString("Name", editTextName.getText().toString());
        editor.putString("Major", editTextMajor.getText().toString());
        editor.putString("ID", editTextStudentID.getText().toString());

        editor.apply(); // asyncronous

    }

    public void saveData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("Name", "Name is not available!");
        String major = sharedPreferences.getString("Major", "Major is not available!");
        String id = sharedPreferences.getString("ID", "ID is not available!");

        txvName.setText(name);
        txvMajor.setText(major);
        txvID.setText(id);
    }
}