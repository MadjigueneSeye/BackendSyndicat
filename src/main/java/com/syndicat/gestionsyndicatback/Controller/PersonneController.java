package com.syndicat.gestionsyndicatback.Controller;

import com.syndicat.gestionsyndicatback.Entity.Personne;
import com.syndicat.gestionsyndicatback.Services.PersonneService;
import com.syndicat.gestionsyndicatback.Services.PersonnesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personne")
public class PersonneController {
    @Autowired
    private PersonneService persService;
    @Autowired
    private PersonnesServices persServices;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/inscription")
    public ResponseEntity<String> inscription(@RequestBody Personne personne) {
   personne.setPassword(bCryptPasswordEncoder.encode(personne.getPassword()));
        persServices.save(personne);
        return ResponseEntity.ok("Inscription réussie !");
    }
    @PostMapping("/authentification")
    public ResponseEntity<Personne> authentification(@RequestBody Personne personne) {
        Personne existingPersonne = persServices.findByUsername(personne.getUsername());
        if (existingPersonne != null && bCryptPasswordEncoder.matches(personne.getPassword(), existingPersonne.getPassword())) {
            return ResponseEntity.ok(existingPersonne);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personne>> getAllPersonnes()
    {
        return ResponseEntity.ok(persService.getAllPersonne());
    }
@PostMapping
    public ResponseEntity ajouterNouvellePersonne ( @RequestBody Personne personne){
         persService.ajouterPersonne(personne);
         return ResponseEntity.ok().build();

}
@PutMapping
public ResponseEntity modifierPersonne(@RequestBody Personne personne) {
        persService.updatePersonne(personne);
        return ResponseEntity.ok().build();
}
@DeleteMapping("/{matricule}")
    public ResponseEntity deletePersonne(@PathVariable("matricule") Long matricule) {
        persService.supprimerPersonne(matricule);
        return ResponseEntity.ok().build();

}
}
