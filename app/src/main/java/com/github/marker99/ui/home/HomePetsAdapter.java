package com.github.marker99.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.marker99.R;
import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.ui.health_inspection.recylerview.HealthInspectionAdapter;

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
        //FIXME: Skal laves til pet_list_item, og den i HealthInspectionAdapter skal ændres
        View view = inflater.inflate(R.layout.pet_real_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePetsAdapter.ViewHolder holder, int position) {
        holder.petName.setText(pets.get(position).getPetName());
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView petName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petName = itemView.findViewById(R.id.rv_tv_petName);

            itemView.setOnClickListener(view -> listener.onClick(pets.get(getBindingAdapterPosition())));
        }
    }

    public void setOnClickListener(HomePetsAdapter.OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        //FIXME: GetSpecificPet skal nu bruge det id fra pettet valgt herunder i stedet for kun at få fat i nr. 1!
        void onClick(Pet pet);
    }
}
