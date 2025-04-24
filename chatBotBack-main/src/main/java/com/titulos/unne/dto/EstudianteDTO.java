package com.titulos.unne.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

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
