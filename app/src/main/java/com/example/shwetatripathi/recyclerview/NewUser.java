package com.example.shwetatripathi.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewUser extends AppCompatActivity {
    EditText name;
    EditText pass;
    TextView dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        dis=findViewById(R.id.disArea);

    }

    //to save data
    public void saveInfo(View view)
    {
        SharedPreferences sharedpref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("username", name.getText().toString());
        editor.putString("password", pass.getText().toString());
        editor.apply();
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    //to display data
    public void displayData(View view)
    {
        SharedPreferences sharedpref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name=sharedpref.getString("username","");
        String pass=sharedpref.getString("password","");
        dis.setText(name +" "+pass);

    }
}
