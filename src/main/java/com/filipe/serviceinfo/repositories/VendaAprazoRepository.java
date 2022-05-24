package com.filipe.serviceinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.serviceinfo.dominian.VendaAprazo;

@Repository
public interface VendaAprazoRepository extends JpaRepository<VendaAprazo, Long>{

}
