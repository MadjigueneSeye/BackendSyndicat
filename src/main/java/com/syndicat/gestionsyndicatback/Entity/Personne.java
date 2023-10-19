package com.syndicat.gestionsyndicatback.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Set;

@Data
@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long matricule;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String password;
    private Integer cin;
    @Enumerated(EnumType.STRING)
    private  RoleUser profil;
    private String adresse;
    private String telephone;



}
