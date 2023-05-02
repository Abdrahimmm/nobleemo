package com.example.noblee.NonActivityClasses.RecycleViewCommantaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noblee.R;
import com.google.firebase.firestore.DocumentReference;

import java.util.List;

public class CommantaireAdapter extends RecyclerView.Adapter<CommantaireHolder> {
    private Context context;
    private List<ItemCommantaire> commantaires;

    public CommantaireAdapter(Context context, List<ItemCommantaire> commantaires) {
        this.context = context;
        this.commantaires = commantaires;
    }

    @NonNull
    @Override
    public CommantaireHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommantaireHolder(LayoutInflater.from(context).inflate(R.layout.layout_commantaire,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommantaireHolder holder, int position) {
        ItemCommantaire commantaire = commantaires.get(position);

        holder.user.setText(commantaire.getUser());
        holder.contenu.setText(commantaire.getContenu());
        holder.suprimerComent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCommentFromDatabase(commantaire.getReference(),position);
            }
        });
    }
    private void deleteCommentFromDatabase(DocumentReference commentId, int position) {
        commentId.delete();
        commantaires.remove(position);
        // Actualiser la RecyclerView
        notifyItemRemoved(position);
        // Code pour supprimer le commentaire de la base de données ou du serveur
        // (cette partie dépend de l'implémentation spécifique)
    }


    @Override
    public int getItemCount() {
        return commantaires.size();
    }
}
