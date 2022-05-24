package com.filipe.serviceinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.serviceinfo.dominian.VendaAvista;

@Repository
public interface VendaAvistaRepository extends JpaRepository<VendaAvista, Long>{

}
