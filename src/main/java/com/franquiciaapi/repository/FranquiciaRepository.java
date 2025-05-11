package com.franquiciaapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franquiciaapi.entidades.Franquicia;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
