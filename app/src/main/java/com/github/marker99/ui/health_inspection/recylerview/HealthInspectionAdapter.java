package com.github.marker99.ui.health_inspection.recylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.marker99.R;
import com.github.marker99.persistence.health_inspection.HealthInspection;

import java.util.List;

public class HealthInspectionAdapter extends RecyclerView.Adapter<HealthInspectionAdapter.ViewHolder> {

    private final List<HealthInspection> inspections;
    private OnClickListener listener;

    public HealthInspectionAdapter(List<HealthInspection> inspections) {
        this.inspections = inspections;
    }

    // Is responsible for converting your single list item layout file from XML
    // into View objects and storing them in a ViewHolder.
    @NonNull
    @Override
    public HealthInspectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pet_list_item, parent, false);
        return new ViewHolder(view);
    }

    // onBindViewHolder(), is responsible for setting the data from the data source on each relevant view.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item.setText(inspections.get(position).getInspectionDate());
    }

    // Specify the length of the data in getItemCount() using your specific data type.
    @Override
    public int getItemCount() {
        return inspections.size();
    }

    // ViewHolder inner class that contains the Views that will be send to the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.rv_tv_item);

            itemView.setOnClickListener(view -> listener.onClick(inspections.get(getBindingAdapterPosition())));

           /* itemView.setOnClickListener(view -> {
                listener.onClick(inspections.get(getBindingAdapterPosition()));
            });*/

        }
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        void onClick(HealthInspection inspection);
    }



}
