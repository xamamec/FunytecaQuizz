package com.example.funytecaquizz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class CategoriaFragment extends Fragment {

    public CategoriaFragment() {
        // Required empty public constructor
    }

    private GridView catView;
    public static List<CategoriaModelo> catList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);

        catView = view.findViewById(R.id.cat_Grid);

        loadCategories();

        CategoriaAdapter adapter = new CategoriaAdapter(catList);
        catView.setAdapter(adapter);

        return view;
    }

    private void loadCategories()
    {
        catList.clear();

        catList.add(new CategoriaModelo("1", "IFAM", 20));
        catList.add(new CategoriaModelo("2", "HISTÓRIA", 30));
        catList.add(new CategoriaModelo("3", "INGLÊS", 10));
        catList.add(new CategoriaModelo("4", "CIÊNCIA", 25));
        catList.add(new CategoriaModelo("5", "MATEMÁTICA", 20));

    }
}