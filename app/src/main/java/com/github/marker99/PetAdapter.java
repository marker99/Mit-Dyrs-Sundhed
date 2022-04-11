package com.github.marker99;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    //Not in use


    // Is responsible for converting your single list item layout file from XML
    // into View objects and storing them in a ViewHolder.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pet_list_item, parent, false);
        return new ViewHolder(view);
    }

    // onBindViewHolder(), is responsible for setting the data from the data source on each relevant view.
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
    }

    // Specify the length of the data in getItemCount() using your specific data type.
    public int getItemCount() {
        return 0;
    }


    // ViewHolder inner class that contains the Views that will be send to the RecyclerView
    class ViewHolder extends RecyclerView.ViewHolder {

        // ViewHolder includes the Views that needs to display data
        private final TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rv_tv_item);
        }
    }


}
