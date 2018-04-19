package com.example.osads.fragmentexample2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class DetailFragment extends Fragment {

    private OnDetailFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        Button button =  view.findViewById(R.id.detail_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateList();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnDetailFragmentInteractionListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() +
                    " должен реализовывать интерфейс OnDetailListFragmentInteractionListener");
        }
    }

    public void updateList() {
        // генерируем некоторые данные
        String curDate = new Date().toString();
        // Посылаем данные Activity
        mListener.onDetailFragmentInteraction(curDate);
    }


    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(item);
    }
}