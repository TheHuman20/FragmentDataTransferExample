package com.example.osads.fragmentexample2;

import android.app.FragmentContainer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class ListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Button button = (Button) view.findViewById(R.id.update_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnListFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implements OnListFragmentInteractionListener interface");
        }
    }
    public void updateDetail() {
        // generating data
        String curDate = new Date().toString();
        // transfer data to activity
        mListener.onListFragmentInteraction(curDate);
    }

    public void setText(String item){
        TextView textView = getView().findViewById(R.id.listText);
        textView.setText(item);
    }
}
