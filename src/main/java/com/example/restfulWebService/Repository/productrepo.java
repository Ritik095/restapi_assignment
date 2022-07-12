package com.example.restfulWebService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulWebService.model.product;

@Repository
public interface productrepo extends JpaRepository<product, Integer>{
	Optional<product>findBypname(String pname);
}
