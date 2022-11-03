package com.example.laba9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    SharedPreferences sPref;

    final String SAVED_LOGIN = "69";
    final String SAVED_PASSWORD = "420";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
    }

    public void save(View v) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putString(SAVED_LOGIN, login.getText().toString());
        ed.putString(SAVED_PASSWORD, password.getText().toString());

        ed.commit();
        Toast.makeText(this, "Логин и пароль сохранены", Toast.LENGTH_SHORT).show();

    }

    public void load(View v) {
        sPref = getPreferences(MODE_PRIVATE);

        String savedLogin = sPref.getString(SAVED_LOGIN, "");
        String savedPassword = sPref.getString(SAVED_PASSWORD, "");

        login.setText(savedLogin);
        password.setText(savedPassword);

        Toast.makeText(this, "Логин и пароль загружены", Toast.LENGTH_SHORT).show();

    }
}