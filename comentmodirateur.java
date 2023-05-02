package com.example.noblee.NonActivityClasses.RecycleViewCommantaire;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noblee.R;
import com.google.firebase.firestore.DocumentReference;

import java.util.List;

public class comentmodirateur extends RecyclerView.Adapter<CommantaireHolder> {
    private Context context;
    private List<ItemCommantaire> commantaires;
    public comentmodirateur(Context context, List<ItemCommantaire> commantaires) {
        this.context = context;
        this.commantaires = commantaires;
    }

    @NonNull
    @Override
    public CommantaireHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommantaireHolder(LayoutInflater.from(context).inflate(R.layout.layout_commantaire, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommantaireHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemCommantaire commantaire = commantaires.get(position);

        holder.user.setText(commantaire.getUser());
        holder.contenu.setText(commantaire.getContenu());

        // Ajouter un OnClickListener pour le bouton de suppression de commentaire
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Supprimer le commentaire à partir de la liste de commentaires
                commantaires.remove(position);
                // Actualiser la RecyclerView
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
                // Supprimer le commentaire de la base de données ou du serveur
                // (cette partie dépend de l'implémentation spécifique)
                deleteCommentFromDatabase(commantaire.getReference());
            }
        });
    }

    @Override
    public int getItemCount() {
        return commantaires.size();
    }

    // Méthode pour supprimer un commentaire de la base de données ou du serveur
    private void deleteCommentFromDatabase(DocumentReference commentId) {
        commentId.delete();
        // Code pour supprimer le commentaire de la base de données ou du serveur
        // (cette partie dépend de l'implémentation spécifique)
    }}
