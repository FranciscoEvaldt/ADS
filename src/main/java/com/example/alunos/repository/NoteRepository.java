
package com.example.alunos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NoteRepository extends JpaRepository<com.example.Alunos.model.Alunos, Long> {
}
