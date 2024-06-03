package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Vuelo;

public interface VueloDAO extends JpaRepository<Vuelo, Integer> {
	@Query("SELECT v FROM Vuelo v WHERE v.plazasDisponibles >= :plazas")
    List<Vuelo> findByPlazasDisponiblesLessThanOrEqual(@Param("plazas") int plazas);
	
	@Query("SELECT CASE WHEN (v.plazasDisponibles - :plazas) < 0 THEN false ELSE true END FROM Vuelo v WHERE v.idVuelo = :id")
    boolean canSubtractPlazas(@Param("plazas") int plazas, @Param("id") int id);
    
	@Modifying
    @Query("UPDATE Vuelo v SET v.plazasDisponibles = v.plazasDisponibles - :plazas WHERE v.idVuelo = :id")
    void subtractPlazas(@Param("plazas") int plazas, @Param("id") int id);
}
