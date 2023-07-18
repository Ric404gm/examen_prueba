package com.ricardocamacho.examen.persistence.entity;

import java.util.List;

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

import lombok.Data;

@Data
@Entity
@Table(name = "examen_pregunta")
public class ExamenPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePregunta;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "respuesta")
    private List<Respuesta> respuestas;

    // @OneToMany(fetch = FetchType.LAZY)
    // @JoinColumn(name = "respuesta_id")
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "respuestas", cascade =
    // CascadeType.ALL)

    /*
     * @OneToMany(mappedBy = "examenPregunta",
     * orphanRemoval = true,
     * fetch = FetchType.LAZY,
     * cascade = CascadeType.ALL)
     */

    /* HERE */

    // @JoinColumn(name = "respuesta_id")
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "respuestaCorrecta", cascade =
    // CascadeType.ALL)
    // @JoinColumn(name = "respuesta_id")
    ///// private Respuesta respuestaCorrecta;

}
