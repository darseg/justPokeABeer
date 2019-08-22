package com.darseg.justPokeABeer.repository;

import com.darseg.justPokeABeer.dbo.BarImagesDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BarImageRepository  extends JpaRepository<BarImagesDBO, Long> {
}
