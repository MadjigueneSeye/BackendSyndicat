package com.syndicat.gestionsyndicatback.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Personne {

    @Id
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Integer cin;
    private String adresse;
    private String telephone;
    private String profil;
    private String login;


}
