package com.example.stjais.sharedprefdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences shrpre;
    EditText etname,etmail;
    Button btnsv,btnshw,btnclr;
    public static final String mypreferences="mypref";
    public static final String Name="nmkey";
    public static final String Email="mailkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=(EditText)findViewById(R.id.etname);
        etmail=(EditText)findViewById(R.id.etmail);
        btnsv=(Button)findViewById(R.id.btnsave);
        btnshw=(Button)findViewById(R.id.btnret);
        btnclr=(Button)findViewById(R.id.btnclr);
        shrpre=getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        if(shrpre.contains(Name)){
            etname.setText(shrpre.getString(Name,""));
        }
        if(shrpre.contains(Email)){
            etmail.setText(shrpre.getString(Email,""));
        }

      }
    public void Save(View v){
        String n=etname.getText().toString();
        String e=etmail.getText().toString();
        SharedPreferences.Editor editor=shrpre.edit();
        editor.putString(Name,n);
        editor.putString(Email,e);
        editor.commit();
    }

    public void Clear(View v){
        etname.setText("");
        etmail.setText("");
    }
    public void get(View v){
        if(shrpre.contains(Name)){
            etname.setText(shrpre.getString(Name,""));
        }
        if(shrpre.contains(Email)){
            etmail.setText(shrpre.getString(Email,""));
        }
    }
}
