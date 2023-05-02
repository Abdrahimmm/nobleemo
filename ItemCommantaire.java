package com.example.noblee.NonActivityClasses.RecycleViewCommantaire;

import com.google.firebase.firestore.DocumentReference;

public class ItemCommantaire {
    String user,contenu;
    DocumentReference reference;

    public ItemCommantaire(String user, String contenu,DocumentReference ref) {
        this.user = user;
        this.contenu = contenu;
        this.reference=ref;
    }

    public ItemCommantaire(String user, String contenu) {
        this.user = user;
        this.contenu = contenu;
    }

    public DocumentReference getReference() {
        return reference;
    }

    public void setReference(DocumentReference reference) {
        this.reference = reference;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    }

