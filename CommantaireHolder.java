package com.example.noblee.NonActivityClasses.RecycleViewCommantaire;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noblee.R;

public class CommantaireHolder extends RecyclerView.ViewHolder {

    public View deleteButton;
    TextView user,contenu;
    ImageView suprimerComent;
    public CommantaireHolder(@NonNull View itemView) {
        super(itemView);

        user = itemView.findViewById(R.id.commantaire_user);
        contenu = itemView.findViewById(R.id.commantaire_contenu);
        suprimerComent =itemView.findViewById(R.id.suprimercoment);
    }
}
