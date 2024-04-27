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
		if(cloudinary.config.cloudName == null){
			System.out.println("Cloudinary servicio no conectado");
		}
		else{
			System.out.println("Cloudinary servicio "+cloudinary.config.cloudName+" Conectado");
		}
		
		SpringApplication.run(EstudiantesRestApiApplication.class, args);
	}

}
