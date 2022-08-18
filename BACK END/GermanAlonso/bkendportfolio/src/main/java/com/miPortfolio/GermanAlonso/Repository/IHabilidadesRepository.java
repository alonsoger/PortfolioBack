
package com.miPortfolio.GermanAlonso.Repository;

import com.miPortfolio.GermanAlonso.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadesRepository extends JpaRepository<Habilidades, Integer>{
    
    public Optional<Habilidades>findByNombreHab(String nombreHab);
    public boolean existsByNombreHab(String nombreHab);
}
