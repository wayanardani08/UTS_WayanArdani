package com.wayan.utswayanardani;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvMakanan;
    private final ArrayList<Makanan> list = new ArrayList<>();


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvMakanan = view.findViewById(R.id.rv_Makanan);
        rvMakanan.setHasFixedSize(true);

        list.addAll(getListMakanan());
        showRecyclerList();

    }
    
    public ArrayList<Makanan> getListMakanan() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Makanan> listMakanan = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Makanan Makanan = new Makanan();
            Makanan.setName(dataName[i]);
            Makanan.setDescription(dataDescription[i]);
            Makanan.setPhoto(dataPhoto.getResourceId(i, -1));
            listMakanan.add(Makanan);
        }
        return listMakanan;
    }

    private void showRecyclerList() {
        rvMakanan.setLayoutManager(new LinearLayoutManager(getContext()));
        ListPesanMakanan listPesanMakanan = new ListPesanMakanan(list);
        rvMakanan.setAdapter(listPesanMakanan);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}