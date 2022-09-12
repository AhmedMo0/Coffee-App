package com.example.demo.controllers;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.CloudinaryService;
import com.example.demo.domain.Product;
import com.example.demo.repos.ProductRepo;

@RestController
@RequestMapping("")
public class FileUploadApi {

	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private ProductRepo productRepo;
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productRepo.save(product),HttpStatus.CREATED);		
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("image") 
	MultipartFile image, @RequestParam("productId") Long productId) throws IOException {
	    
		String url;
		try {
			url = cloudinaryService.uploadFile(image, productId);
			
			LinkedHashMap<String, Object> jsonResponse = new LinkedHashMap<>();
			jsonResponse.put("ImageUrl", url);
			
			return new ResponseEntity<>(jsonResponse,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	    
		
		
		
		
	}
}
