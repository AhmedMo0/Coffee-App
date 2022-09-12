package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudConfig {

	@Autowired
	@Value("${imageH.cloud_name}")
	String cloudName;
	
	@Autowired
	@Value("${imageH.api_key}")
	String apiKey;
	
	@Autowired
	@Value("${imageH.api_secret}")
	String apiSecret;
	
    @Bean
    public Cloudinary cConfig() {
        Cloudinary cloudinary = null;
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

}
