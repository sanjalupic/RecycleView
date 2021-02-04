package com.example.recycleview;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvName;
    private NameClickListener clickListener;
    private Button btnRemove;

    public NameViewHolder(@NonNull View itemView, NameClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        tvName = itemView.findViewById(R.id.tvName);
        btnRemove = itemView.findViewById(R.id.btnRemove);
        itemView.setOnClickListener(this);
        btnRemove.setOnClickListener(this);

    }

    public void setName(String name) {
        tvName.setText(name);
    }


    @Override
    public void onClick(View view) {
        clickListener.ClickButton(getAdapterPosition());
    }
}

