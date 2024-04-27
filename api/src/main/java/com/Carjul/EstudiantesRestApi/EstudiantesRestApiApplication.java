package com.Carjul.EstudiantesRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Import the required packages

import com.cloudinary.*;
import io.github.cdimascio.dotenv.Dotenv;





@SpringBootApplication
public class EstudiantesRestApiApplication {
	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
		cloudinary.config.secure = true;
		System.out.println(cloudinary.config.cloudName);
		SpringApplication.run(EstudiantesRestApiApplication.class, args);
	}

}
