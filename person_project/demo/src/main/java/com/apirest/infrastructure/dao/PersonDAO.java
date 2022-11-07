package com.apirest.infrastructure.dao;

import com.apirest.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//extends JpaRepository<Person, Long>
public interface PersonDAO extends JpaRepository<Person, String> {

}
