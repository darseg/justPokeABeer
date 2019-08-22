package com.darseg.justPokeABeer.repository;

import com.darseg.justPokeABeer.dbo.BarContactDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BarContactRepository  extends JpaRepository<BarContactDBO, Long> {
}
