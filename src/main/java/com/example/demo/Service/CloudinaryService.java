package com.example.demo.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.config.CloudConfig;
import com.example.demo.domain.Product;
import com.example.demo.repos.ProductRepo;

@Service
public class CloudinaryService {

	@Autowired
	private Cloudinary cloudinaryConfig;
	@Autowired
	private ProductRepo productRepo;
	
	
	public String uploadFile(MultipartFile img, Long productId) throws Exception
	{
		Product product = productRepo.findById(productId).orElse(null);
		if(product == null)
		{
			throw new Exception(String.format("product with id= %d ",productId) );
		}
		
		String resUrl = "";
		File uploadedFile;
		try {
			uploadedFile = convertMultiPartToFile(img);
			Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
			boolean isDeleted = uploadedFile.delete();
			resUrl = uploadResult.get("url").toString();
			product.setImageLink(resUrl);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	
		return resUrl;
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
}
