package com.darseg.justPokeABeer.repository;

import com.darseg.justPokeABeer.dbo.BarDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BarRepository extends JpaRepository<BarDBO, Long> {
	
	BarDBO getByBid(Long bid);

	@Override
	BarDBO save(BarDBO s);

	@Override
	<S extends BarDBO> List<S> saveAll(Iterable<S> iterable);
}
