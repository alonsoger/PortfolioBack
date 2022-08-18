package com.miPortfolio.GermanAlonso.Repository;

import com.miPortfolio.GermanAlonso.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProyectoRepository extends JpaRepository <Proyecto, Integer> {
}
