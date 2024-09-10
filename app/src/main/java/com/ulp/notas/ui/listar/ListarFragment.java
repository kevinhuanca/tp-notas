package com.ulp.notas.ui.listar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulp.notas.R;
import com.ulp.notas.databinding.FragmentListarBinding;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;

    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getNotas().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> notas) {
                NotaAdapter adapter = new NotaAdapter(notas, inflater);
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.rvLista.setAdapter(adapter);
                binding.rvLista.setLayoutManager(glm);
            }
        });
        mViewModel.cargarNotas();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        // TODO: Use the ViewModel
    }

}