package com.capgemini.greeting_spring.repository;

import com.capgemini.greeting_spring.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepo extends JpaRepository<GreetingEntity,Long> {
}
