package com.titulos.unne.controlador;

import com.titulos.unne.dto.EstudianteDTO;
import com.titulos.unne.servicio.EstudianteServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unne/estudiantes")
public class EstudianteControlador {

    private final EstudianteServicio estudianteServicio;

    public EstudianteControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @GetMapping("/{lu}")
    public EstudianteDTO obtenerEstudiante(@PathVariable int lu) {
        return estudianteServicio.obtenerPorLU(lu);
    }

    @GetMapping("/{lu}/estado-titulo-por-tipo")
    public String estadoTituloPorTipo(@PathVariable int lu,
            @RequestParam(defaultValue = "grado") String tipo) {
        return estudianteServicio.estadoTitulo(lu, tipo);
    }
}
