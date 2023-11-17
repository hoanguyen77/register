package org.hoanguyen.register.repository;

import org.hoanguyen.register.entity.Senior;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeniorRepository extends CrudRepository<Senior, Integer> {
    public Optional<Senior> findSeniorByEmail (String email);
}