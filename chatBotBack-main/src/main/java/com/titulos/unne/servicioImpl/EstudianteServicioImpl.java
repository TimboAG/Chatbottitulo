package com.titulos.unne.servicioImpl;

import com.titulos.unne.dto.EstudianteDTO;
import com.titulos.unne.entidad.Estudiante;
import com.titulos.unne.mapper.EstudianteMapper;
import com.titulos.unne.repositorio.EstudianteRepositorio;
import com.titulos.unne.servicio.EstudianteServicio;
import com.titulos.unne.servicio.ScraperServicio;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

    private final EstudianteRepositorio estudianteRepository;

   private final ScraperServicio scraperServicio;

public EstudianteServicioImpl(EstudianteRepositorio estudianteRepository, ScraperServicio scraperServicio) {
    this.estudianteRepository = estudianteRepository;
    this.scraperServicio = scraperServicio;
}
    @Override
    public EstudianteDTO obtenerPorLU(int lu) {
        return estudianteRepository.findByLu(lu)
            .map(EstudianteMapper::toDTO)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

   @Override
public String estadoTitulo(int lu, String tipo) {
    Optional<Estudiante> optionalEstudiante = estudianteRepository.findByLu(lu);

    if (!optionalEstudiante.isPresent()) {
        return "Estudiante no encontrado.";
    }

    Estudiante estudiante = optionalEstudiante.get();
    double porcentaje = 0;
    String mensaje = "Tu porcentaje de carrera es: ";

    boolean puedeSolicitar = false;

    if ("pregrado".equalsIgnoreCase(tipo)) {
        if (estudiante.getTotalMateriasPregrado() > 0) {
            porcentaje = (estudiante.getMateriasAprobadasPregrado() * 100.0) / estudiante.getTotalMateriasPregrado();
        }
        mensaje += String.format("%.2f", porcentaje) + "%. ";
        if (porcentaje >= 100) {
            puedeSolicitar = true;
            mensaje += "¡Podés solicitar tu título intermedio: Analista Programador Universitario!\n\n";
        } else {
            mensaje += "Todavía no podés solicitar este título. Necesitás aprobar más materias.";
        }

    } else {
        if (estudiante.getTotalMateriasGrado() > 0) {
            porcentaje = (estudiante.getMateriasAprobadasGrado() * 100.0) / estudiante.getTotalMateriasGrado();
        }
        mensaje += String.format("%.2f", porcentaje) + "%. ";
        if (porcentaje >= 100) {
            puedeSolicitar = true;
            mensaje += "¡Podés solicitar tu título de grado: Licenciado/a en Sistemas de Información!\n\n";
        } else {
            mensaje += "Todavía no podés solicitar este título. Necesitás aprobar más materias.";
        }
    }

    if ("2009".equals(estudiante.getPlanEstudio())) {
        mensaje += "\nRecordá que el Plan 2009 vence en el año 2032.";
    }

    if (puedeSolicitar) {
        String pasos = scraperServicio.obtenerContenidoTituloUNNE();
        mensaje += "\n\n📋 Pasos para tramitar el título:\n" + pasos;
    }

    return mensaje;
}

}
