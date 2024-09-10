package com.ulp.notas.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ulp.notas.R;

import java.util.ArrayList;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolderNota> {

    private ArrayList<String> notas;
    private LayoutInflater li;

    public NotaAdapter(ArrayList<String> notas, LayoutInflater li) {
        this.notas = notas;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderNota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderNota(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNota holder, int position) {
        String nota = notas.get(position);
        holder.tvNota.setText(nota);
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolderNota extends RecyclerView.ViewHolder {

        TextView tvNota;

        public ViewHolderNota(@NonNull View itemView) {
            super(itemView);

            tvNota = itemView.findViewById(R.id.tvNota);

        }
    }

}
