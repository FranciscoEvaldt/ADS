package com.example.alunos.controller;

import com.example.alunos.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AlunosController {

    @Autowired
    AlunosRepository alunosRepository;
    //Recuperar todas as notas
    @GetMapping("/alunos")
    public List<com.example.Alunos.model.Alunos> getAllAlunos(){
        return alunosRepository.findAll();
    }
    @GetMapping("/alunos/{id}")
    public Optional<com.example.Alunos.model.Alunos> getById(@PathVariable(value = "id") Long id){
        return alunosRepository.findById(id);
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id){
        Optional <com.example.Alunos.model.Alunos> note = alunosRepository.findById(id);
        alunosRepository.delete(note.get());
        return ResponseEntity.ok().build();
    }
    @PutMapping("/alunos/{id}")
    public com.example.Alunos.model.Alunos updateNote(@PathVariable(value = "id") Long id,
                                                      @Valid @RequestBody com.example.Alunos.model.Alunos alunosDetails){
        Optional<com.example.Alunos.model.Alunos> note = alunosRepository.findById(id);
        note.get().setId(alunosDetails.getId());
        note.get().setName(alunosDetails.getName());
        note.get().setTurma(alunosDetails.getTurma());
        return alunosRepository.save(note.get());
    }
    @PostMapping("/alunos")
    public com.example.Alunos.model.Alunos createNote(@Valid @RequestBody com.example.Alunos.model.Alunos alunos){
        return alunosRepository.save(alunos);
    }

}
