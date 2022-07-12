package com.example.restfulWebService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restfulWebService.model.category_log;



@Repository
public interface categoryRepo extends JpaRepository<category_log, Integer>{
	Optional<category_log>deleteBycategory_log(String cate_name);
	Optional<category_log>findBycategory_log(String cate_name);
}
