package com.filipe.serviceinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.serviceinfo.dominian.ADM;

@Repository
public interface ADMRepository extends JpaRepository<ADM, Long>{

	@Query("SELECT obj FROM ADM obj WHERE obj.cpf =:cpf")
	ADM findByCPF(@Param("cpf") String cpf);
}
