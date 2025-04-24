package com.titulos.unne.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    private Long id;

    private String nombreYapellido;
    private String planEstudio;
    private int lu;

    private int materiasAprobadasGrado;
    private int totalMateriasGrado;

    private int materiasAprobadasPregrado;
    private int totalMateriasPregrado;

    private boolean tituloSolicitado;
}
