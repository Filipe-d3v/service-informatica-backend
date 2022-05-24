package com.filipe.serviceinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.serviceinfo.dominian.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Long>{

	
}
