package com.gogreen.gogreen.Views.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gogreen.gogreen.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle(R.string.new_user_register);
    }
}
