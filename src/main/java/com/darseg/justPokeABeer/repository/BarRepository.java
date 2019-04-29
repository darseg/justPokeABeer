package com.darseg.justPokeABeer.repository;

import com.darseg.justPokeABeer.dbo.BarDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BarRepository extends JpaRepository<BarDBO, Long> {
	
	BarDBO getByBid(Long bid);
	
	
}
