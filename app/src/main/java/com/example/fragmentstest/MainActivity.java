package com.example.fragmentstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String data) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().
                findFragmentById(R.id.detailFragment);
        assert detailFragment != null;
        detailFragment.setSelectedItem(data);
    }
}