package com.example.restfulWebService.Services;

import java.nio.file.FileAlreadyExistsException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.naming.directory.NoSuchAttributeException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.example.restfulWebService.CustumExceptions.productNotFoundException;
import com.example.restfulWebService.Repository.categoryRepo;
import com.example.restfulWebService.Repository.productrepo;
import com.example.restfulWebService.model.category_log;
import com.example.restfulWebService.model.product;



public class productServiceImplemtor {
	@Autowired
	private productrepo productRepository;
	
	@Autowired
	private categoryRepo catalogRepository;

	public List<product> getAllProducts() throws NoSuchAttributeException {
		List<product> results = this.productRepository.findAll();
		if(results.size() <=0 ) {
			throw new NoSuchAttributeException("No products Listed");
		}
		return results;
	}

	public product createProduct(product product) throws FileAlreadyExistsException,IncorrectResultSizeDataAccessException {
		Optional<product> productName = this.productRepository.findBypname(product.getPname());
		if(!productName.isPresent()) {
			this.catalogRepository.save(new category_log(0,product.getPcat_name(),new HashSet<>(List.of( product))));
			return product;
		}
		throw new FileAlreadyExistsException("product is Already Exist");
	}

	public category_log UpdateProduct(product product) throws productNotFoundException,IncorrectResultSizeDataAccessException{
		Optional<product> pname = this.productRepository.findBypname(product.getPname());
		if(pname.isPresent()) {
			pname.get().setPcat_name(product.getPcat_name());
			pname.get().setPname(product.getPname());
			pname.get().setPprice(product.getPprice());			
			return this.catalogRepository.save(new category_log(1,product.getPcat_name(),new HashSet<>(List.of( product.get()))));
		}
		throw new productNotFoundException("product Not Listed/Registered");
	}

	public String DeleteProduct(String pname) throws NoSuchAttributeException{
		Optional<product> deleteBypname = this.productRepository.findBypname(pname);
		if(deleteBypname.isPresent()) {
			this.productRepository.deleteById(deleteBypname.get().getId());
			this.catalogRepository.deleteBycategory_log(deleteBypname.get().getPcat_name());
			return pname+" Deleted";
		}
		throw new NoSuchAttributeException("product Not Listed/Registered");
	}

}
