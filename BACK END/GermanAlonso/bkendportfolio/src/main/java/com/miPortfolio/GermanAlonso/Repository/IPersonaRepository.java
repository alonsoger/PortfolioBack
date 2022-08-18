
package com.miPortfolio.GermanAlonso.Repository;

import com.miPortfolio.GermanAlonso.Entity.Persona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IPersonaRepository extends JpaRepository <Persona, Integer> {

    public List<Persona> findAllById(SingularAttribute<AbstractPersistable, Serializable> id);

}
