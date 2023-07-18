package com.ricardocamacho.examen.persistence.entity;

import java.util.List;

import javax.management.Notification;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "examen")
public class Examen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    //@OneToMany(fetch = FetchType.LAZY)
    //@OneToMany(mappedBy = "examen", fetch = FetchType.LAZY,
    //cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "mCustomer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    /*  @OneToMany(mappedBy = "examen",
               orphanRemoval = true,
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL) */
    //@OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "examen_pregunta")
    private java.util.List<ExamenPregunta> preguntas;
    

}
