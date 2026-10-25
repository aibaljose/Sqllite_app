package com.aibal.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


EditText E1;
TextView T1;


DatabaseHelper dbhelper;




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

        E1 = (EditText)findViewById(R.id.editTextText);
        T1 =(TextView)findViewById(R.id.textView);
        dbhelper = new DatabaseHelper(this);




    }

    public void addme(View view) {

        String name = E1.getText().toString();

        if(dbhelper.addName(name)){
            Toast.makeText(this, "Name added"+name, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "failed to add", Toast.LENGTH_SHORT).show();

        }
    }

    public void showdata(View view) {
        String names = dbhelper.getAllNames();
        T1.setText(names);
    }
}