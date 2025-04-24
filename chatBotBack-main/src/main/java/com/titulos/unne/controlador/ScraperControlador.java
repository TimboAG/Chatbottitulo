
package com.titulos.unne.controlador;

import com.titulos.unne.servicio.ScraperServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unne/scraper")
public class ScraperControlador {
      private final ScraperServicio scraperServicio;

    public ScraperControlador(ScraperServicio scraperServicio) {
        this.scraperServicio = scraperServicio;
    }

    @GetMapping("/titulo")
    public ResponseEntity<String> obtenerInfoTitulo() {
        String info = scraperServicio.obtenerContenidoTituloUNNE();
        return ResponseEntity.ok(info);
    }
}
