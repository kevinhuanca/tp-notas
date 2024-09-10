package com.ulp.notas.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.notas.MainActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> notas;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<String>> getNotas() {
        if (notas == null) {
            notas = new MutableLiveData<>();
        }
        return notas;
    }

    public void cargarNotas() {
        Collections.sort(MainActivity.notas);
        notas.setValue(MainActivity.notas);
    }

}