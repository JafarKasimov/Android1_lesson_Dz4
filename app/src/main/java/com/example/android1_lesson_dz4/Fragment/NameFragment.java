package com.example.android1_lesson_dz4.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1_lesson_dz4.CatModel;
import com.example.android1_lesson_dz4.CatsRepository;
import com.example.android1_lesson_dz4.NamesAdapter;
import com.example.android1_lesson_dz4.OnClickItemCat;
import com.example.android1_lesson_dz4.R;


public class NameFragment extends Fragment implements OnClickItemCat {

    private final CatsRepository catsRepository = new CatsRepository();
    private final NamesAdapter namesAdapter = new NamesAdapter();
    private RecyclerView recyclerView;

    public NameFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_names);
        recyclerView.setLayoutManager(new LinearLayoutManager
                (getContext(), RecyclerView.VERTICAL, false));

        recyclerView.setAdapter(namesAdapter);
        namesAdapter.setListCat(catsRepository.getListOfCatHTP());
        namesAdapter.setOnClickItemCat(this);
    }

    @Override
    public void listenerClickItemCat(CatModel listCats) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("cat", listCats);
        getParentFragmentManager().beginTransaction()
                .add(R.id.fragment_container_view, DetailFragment.class, bundle)
                .addToBackStack("NameFragment")
                .commit();

    }
}