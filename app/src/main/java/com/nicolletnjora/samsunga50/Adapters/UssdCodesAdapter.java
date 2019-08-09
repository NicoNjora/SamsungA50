package com.nicolletnjora.samsunga50.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nicolletnjora.samsunga50.Models.UssdCode;
import com.nicolletnjora.samsunga50.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UssdCodesAdapter extends RecyclerView.Adapter<UssdCodesAdapter.ussdCodeViewHolder> implements Filterable {

    private List<UssdCode> UssdCode;
    private Context mContext;

    public UssdCodesAdapter(Context mContext, List<UssdCode> UssdCode) {
        this.mContext = mContext;
        this.UssdCode = UssdCode;
    }

    @NonNull
    @Override
    public ussdCodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ussd_card, parent, false);

        return new ussdCodeViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ussdCodeViewHolder holder, int position) {

        UssdCode ussdCode = UssdCode.get(position);
        holder.ussdCodePathDescription.setText(ussdCode.getUssdCodePathDescription());
        holder.ussdCodePath.setText(ussdCode.getUssdCodePath());

    }

    @Override
    public int getItemCount() {
        return UssdCode.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    class ussdCodeViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ussdCodePath)
        TextView ussdCodePath;

        @BindView(R.id.ussdCodePathDescription)
        TextView ussdCodePathDescription;

        public ussdCodeViewHolder(View view) {
            super(view);

            // binding view
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                }
            });
        }
    }
}
