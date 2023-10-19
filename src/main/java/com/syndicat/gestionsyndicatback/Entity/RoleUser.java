package com.syndicat.gestionsyndicatback.Entity;

import lombok.Getter;

@Getter
public enum RoleUser {
    Administrateur("Administrateur"),
    Tresorier("Tresorier"),
    SG("SG"),
    Membre("Membre");
    final String message;

    RoleUser(String message) {
        this.message = message;
    }
}
