
package com.miPortfolio.GermanAlonso.Security.Repository;

import com.miPortfolio.GermanAlonso.Security.Entity.Rol;
import com.miPortfolio.GermanAlonso.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository <Rol, Integer> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
