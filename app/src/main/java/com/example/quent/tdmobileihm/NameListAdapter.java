package com.example.quent.tdmobileihm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NameListAdapter extends RecyclerView.Adapter<NameViewHolder> {

    private final List<String> nameList;

    public NameListAdapter() {
        this.nameList = new ArrayList<>();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_name,viewGroup,false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int i) {
        nameViewHolder.setContent(nameList.get(i));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void updateList(List<String> nameList) {
        this.nameList.clear();
        this.nameList.addAll(nameList);
        notifyDataSetChanged();
    }
}
