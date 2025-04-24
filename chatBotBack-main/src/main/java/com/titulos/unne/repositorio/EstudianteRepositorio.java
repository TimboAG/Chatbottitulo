
package com.titulos.unne.repositorio;

import com.titulos.unne.entidad.Estudiante;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
        Optional<Estudiante> findByLu(int lu); 

}
