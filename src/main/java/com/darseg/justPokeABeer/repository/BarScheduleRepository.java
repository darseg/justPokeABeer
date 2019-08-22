package com.darseg.justPokeABeer.repository;

import com.darseg.justPokeABeer.dbo.BarScheduleDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BarScheduleRepository extends JpaRepository<BarScheduleDBO, Long> {
    BarScheduleDBO save(BarScheduleDBO s);

    @Override
    <S extends BarScheduleDBO> List<S> saveAll(Iterable<S> iterable);

    //List<BarScheduleDBO> saveAll(List<BarScheduleDBO> s);
}
