package com.controlfacil.controlcovid.UI;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.controlfacil.controlcovid.R;
import com.controlfacil.controlcovid.Databases.Entities.TareaEntity;


import java.util.List;

public class MyTareaRecyclerViewAdapter extends RecyclerView.Adapter<MyTareaRecyclerViewAdapter.ViewHolder> {

    private List<TareaEntity> mValues;
    private Context ctx;
    private NuevaTareaDialogViewModel viewModel;

    public MyTareaRecyclerViewAdapter(List<TareaEntity> items, Context ctx) {
        mValues = items;
        this.ctx = ctx;
        viewModel = ViewModelProviders.of((AppCompatActivity)ctx).get(NuevaTareaDialogViewModel.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvContenido.setText(holder.mItem.getContenido());

        if(holder.mItem.isFavorita()) {
            holder.ivFavorita.setImageResource(R.drawable.ic_star_black_24dp);
        }

        holder.ivFavorita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.mItem.isFavorita()) {
                    holder.mItem.setFavorita(false);
                    holder.ivFavorita.setImageResource(R.drawable.ic_star_border_black_24dp);

                } else {
                    holder.mItem.setFavorita(true);
                    holder.ivFavorita.setImageResource(R.drawable.ic_star_black_24dp);
                }
                viewModel.updateNota(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setNuevasNotas(List<TareaEntity> nuevasNotas) {
        this.mValues = nuevasNotas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTitulo;
        public final TextView tvContenido;
        public final ImageView ivFavorita;
        public TareaEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitulo = view.findViewById(R.id.textViewTitulo);
            tvContenido = view.findViewById(R.id.textViewContenido);
            ivFavorita = view.findViewById(R.id.imageViewFavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}
