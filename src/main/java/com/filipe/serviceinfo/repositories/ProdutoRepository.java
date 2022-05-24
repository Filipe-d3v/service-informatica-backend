package com.filipe.serviceinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filipe.serviceinfo.dominian.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("SELECT obj FROM Produto obj WHERE obj.id =:id")
	Produto findByNome(@Param("id") Long id);
}
