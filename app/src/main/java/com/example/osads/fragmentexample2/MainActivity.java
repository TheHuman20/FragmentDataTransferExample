package com.example.osads.fragmentexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener,
                                                                OnDetailFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(String link) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }

    @Override
    public void onDetailFragmentInteraction(String link) {
        ListFragment fragment = (ListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.listFragment);
        if(fragment!=null && fragment.isInLayout()){
            fragment.setText(link);
        }
    }
}