package com.titulos.unne.servicio;

import com.titulos.unne.dto.EstudianteDTO;

public interface EstudianteServicio {
    EstudianteDTO obtenerPorLU(int lu);
 String estadoTitulo(int lu, String tipo);

         }
