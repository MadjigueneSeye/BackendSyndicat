package com.syndicat.gestionsyndicatback.Controller;

import com.syndicat.gestionsyndicatback.Entity.Personne;
import com.syndicat.gestionsyndicatback.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personne")
public class PersonneController {
    @Autowired
    private PersonneService persService;

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
    public ResponseEntity deletePersonne(@PathVariable("matricule") String matricule) {
        persService.supprimerPersonne(matricule);
        return ResponseEntity.ok().build();

}
}
