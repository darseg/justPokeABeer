package com.darseg.justPokeABeer.repository;

import com.darseg.justPokeABeer.dbo.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserDBO, Long> {

	UserDBO getByUid(Long uid);
}
