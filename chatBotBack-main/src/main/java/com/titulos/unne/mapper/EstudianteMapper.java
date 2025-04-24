package com.titulos.unne.mapper;

import com.titulos.unne.dto.EstudianteDTO;
import com.titulos.unne.entidad.Estudiante;

public class EstudianteMapper {

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombreYapellido(estudiante.getNombreYapellido());
        dto.setPlanEstudio(estudiante.getPlanEstudio());
        dto.setLu(estudiante.getLu());

        dto.setMateriasAprobadasGrado(estudiante.getMateriasAprobadasGrado());
        dto.setTotalMateriasGrado(estudiante.getTotalMateriasGrado());

        dto.setMateriasAprobadasPregrado(estudiante.getMateriasAprobadasPregrado());
        dto.setTotalMateriasPregrado(estudiante.getTotalMateriasPregrado());

        dto.setTituloSolicitado(estudiante.isTituloSolicitado());
        return dto;
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(dto.getId());
        estudiante.setNombreYapellido(dto.getNombreYapellido());
        estudiante.setPlanEstudio(dto.getPlanEstudio());
        estudiante.setLu(dto.getLu());

        estudiante.setMateriasAprobadasGrado(dto.getMateriasAprobadasGrado());
        estudiante.setTotalMateriasGrado(dto.getTotalMateriasGrado());

        estudiante.setMateriasAprobadasPregrado(dto.getMateriasAprobadasPregrado());
        estudiante.setTotalMateriasPregrado(dto.getTotalMateriasPregrado());

        estudiante.setTituloSolicitado(dto.isTituloSolicitado());
        return estudiante;
    }
}
