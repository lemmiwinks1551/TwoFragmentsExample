package com.example.fragmentstest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void setSelectedItem(String selectedItem) {
        TextView textView = getView().findViewById(R.id.detailsText);
        textView.setText(selectedItem);
    }
}
