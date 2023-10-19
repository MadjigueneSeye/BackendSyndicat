package com.syndicat.gestionsyndicatback.Services;

import com.syndicat.gestionsyndicatback.Entity.Personne;

public interface PersonnesServices {
    void save(Personne personne);
    Personne findByUsername(String username);
}
