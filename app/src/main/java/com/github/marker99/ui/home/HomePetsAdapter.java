package com.github.marker99.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.marker99.R;
import com.github.marker99.persistence.pet.Pet;

import java.util.List;

public class HomePetsAdapter extends RecyclerView.Adapter<HomePetsAdapter.ViewHolder> {
    private final List<Pet> pets;
    private OnClickListener listener;

    public HomePetsAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    // Is responsible for converting your single list item layout file from XML
    // into View objects and storing them in a ViewHolder.
    @NonNull
    @Override
    public HomePetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_pet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePetsAdapter.ViewHolder holder, int position) {
        holder.petName.setText(pets.get(position).getPetName());
        int petId = holder.itemView.getContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE).getInt("petId", 0);
        if(pets.get(position).getId() == petId)
        {
            holder.selected.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView petName;
        private final CheckBox selected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petName = itemView.findViewById(R.id.rv_tv_petName);
            selected = itemView.findViewById(R.id.rv_checkbox_selected);

            itemView.setOnClickListener(view -> listener.onClick(pets.get(getBindingAdapterPosition())));
        }
    }

    public void setOnClickListener(HomePetsAdapter.OnClickListener listener) {
        this.listener = listener;

        //Clean all checkboxes

        //Set selected pet checkbox
    }

    public interface OnClickListener {
        void onClick(Pet pet);
    }
}
