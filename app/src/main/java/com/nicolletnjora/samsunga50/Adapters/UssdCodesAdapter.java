package com.nicolletnjora.samsunga50.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UssdCodesAdapter extends RecyclerView.Adapter<UssdCodesAdapter.ussdCodeViewHolder> {


    @NonNull
    @Override
    public ussdCodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ussdCodeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ussdCodeViewHolder extends RecyclerView.ViewHolder{

        public ussdCodeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
