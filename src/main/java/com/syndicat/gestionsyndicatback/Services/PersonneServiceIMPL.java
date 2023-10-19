package com.syndicat.gestionsyndicatback.Services;

import com.syndicat.gestionsyndicatback.Entity.Personne;
import com.syndicat.gestionsyndicatback.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonneServiceIMPL implements PersonnesServices {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private PersonneRepository personneRepository;
    @Override
    public void save(Personne personne) {
        personneRepository.save(personne);

    }

    @Override
    public Personne findByUsername(String username) {
        return personneRepository.findByUsername(username);
    }
}
