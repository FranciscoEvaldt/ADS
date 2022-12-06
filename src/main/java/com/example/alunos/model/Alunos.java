package com.example.Alunos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "alunos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAT ","updateAT"}, allowGetters = true)

public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotBlank
    private String Id;
    @NotBlank
    private String Name;
    @NotBlank
    private String Turma;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAT;

    @Column(nullable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAT;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {this.Id = Id;
    }

    public String getName() {return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTurma() {return Turma;
    }

    public void setTurma(String Turma) {
        this.Turma = Turma;
    }

    public Date getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(Date createdAT) {
        this.createdAT = createdAT;
    }

    public Date getUpdateAT() {
        return updateAT;
    }

    public void setUpdateAT(Date updateAT) {
        this.updateAT = updateAT;
    }
}

