package com.example.restfulWebService.Services;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import javax.naming.directory.NoSuchAttributeException;

import com.example.restfulWebService.CustumExceptions.productNotFoundException;
import com.example.restfulWebService.model.category_log;
import com.example.restfulWebService.model.product;




public interface productServices {
	List<product> getAllProducts()throws NoSuchAttributeException;
	product createProduct(product product)throws FileAlreadyExistsException;
	category_log UpdateProduct(product product) throws productNotFoundException;
	String DeleteProduct(String productName) throws NoSuchAttributeException;
}
