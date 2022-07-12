 package com.example.restfulWebService.Controllers;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import javax.naming.directory.NoSuchAttributeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulWebService.CustumExceptions.productNotFoundException;
import com.example.restfulWebService.Services.productServices;
import com.example.restfulWebService.model.category_log;
import com.example.restfulWebService.model.product;



@RestController
 @RequestMapping("/ritik/main")
public class productController {
	
	@Autowired
	
	private productServices services;
	
	
	@PostMapping("/EnroleNewProduct")
	public ResponseEntity<?> AddNewProduct(@RequestBody product product) throws FileAlreadyExistsException{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.services.createProduct(product));
	}

	@GetMapping("/ListOfProducts")
	public ResponseEntity<List<product>> ListOfProducts() throws NoSuchAttributeException{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.services.getAllProducts());
	}

	@PutMapping("/ModifyProduct")
	public ResponseEntity<category_log> UpdateProduct(@RequestBody product product) throws productNotFoundException{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.services.UpdateProduct(product));
	}

	@DeleteMapping("/DeleteProduct/{productName}")
	public ResponseEntity<?> DeleteProduct(@PathVariable String productName) throws NoSuchAttributeException{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.services.DeleteProduct(productName));
	}
}
