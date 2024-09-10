package com.ulp.notas.ui.cargar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.notas.MainActivity;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mensaje;
    private MutableLiveData<String> escrito;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensaje() {
        if (mensaje == null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public LiveData<String> getEscrito() {
        if (escrito == null) {
            escrito = new MutableLiveData<>();
        }
        return escrito;
    }

    public void validarNota(String nota) {
        if (nota.trim().isEmpty()) {
            mensaje.setValue("Escriba algo...");
        } else {
            MainActivity.notas.add(nota);
            escrito.setValue("");
            mensaje.setValue("");
            Toast.makeText(getApplication(), "Nota guardada con exito!", Toast.LENGTH_LONG).show();
        }
    }

}