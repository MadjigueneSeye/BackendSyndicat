package com.syndicat.gestionsyndicatback.Services;
import com.syndicat.gestionsyndicatback.Entity.Personne;
import com.syndicat.gestionsyndicatback.Repository.PersonneRepository;
import com.syndicat.gestionsyndicatback.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

public void ajouterPersonne (Personne personne) {
    if(validerPersonne(personne)) {
    personneRepository.save(personne);
    }
}
public void updatePersonne (Personne personne){
    if(!personneRepository.existsById(personne.getMatricule())){
        System.out.println("cette personne n'existe pas");
    }
personneRepository.save(personne);
}

public void supprimerPersonne(String idpers){
personneRepository.deleteById(idpers);
}
    public List<Personne> getAllPersonne() {

    return personneRepository.findAll();
    }
public boolean validerPersonne (Personne personne){

    return personne != null &&
            personne.getMatricule() != null &&
            !personne.getMatricule().isEmpty() &&
            !personneRepository.existsById(personne.getMatricule());
}

}
