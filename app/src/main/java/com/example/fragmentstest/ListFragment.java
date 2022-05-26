package com.example.fragmentstest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    private OnFragmentSendDataListener fragmentSendDataListener;

    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    // набор данных, которые свяжем со списком
    String[] countries = {"Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Устанавливается слушатель к активности, которая вызывает фрагмент
        fragmentSendDataListener = (OnFragmentSendDataListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Получаем элемент ListView
        ListView countriesList = view.findViewById(R.id.countriesList);

        // Создаем адаптер и передаем ему массив для отображения
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, countries);

        // Устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);

        // Добавляем для списка слушатель
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // получаем выбранный элемент
                String selectedItem = (String) parent.getItemAtPosition(position);
                // Посылаем данные Activity
                fragmentSendDataListener.onSendData(selectedItem);
            }
        });
        return view;
    }
}
