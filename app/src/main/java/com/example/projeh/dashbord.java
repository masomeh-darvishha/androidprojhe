package com.example.projeh;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projeh.databinding.FragmentDashbordBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class dashbord extends Fragment {


    public dashbord() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @NonNull FragmentDashbordBinding binding;
    FirebaseFirestore database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentDashbordBinding.inflate(inflater,container,false);

        database=FirebaseFirestore.getInstance();

        ArrayList<Cmodel> categories=new ArrayList<>();
        categories.add(new Cmodel("https://pics.freeicons.io/uploads/icons/png/10320105721596026964-512.png","اتومبیل - بنزین","",""));
        categories.add(new Cmodel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1sFj5oCd_nZDDLPnLHcl_LaMjL8fjtjWr5w&usqp=CAU","خوراک - رستوران","",""));
        categories.add(new Cmodel("https://thumbs.dreamstime.com/b/pizza-vector-icon-italian-fast-food-cafe-logo-illustration-pizzeria-icon-pizza-vector-icon-italian-fast-food-cafe-logo-150445333.jpg","خرید - لباس","",""));
        categories.add(new Cmodel("data:image/png;base64,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","حقوق ","",""));
        Cadapter adapter=new Cadapter(this,categories);


                        adapter.notifyDataSetChanged();


        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        binding.recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}

