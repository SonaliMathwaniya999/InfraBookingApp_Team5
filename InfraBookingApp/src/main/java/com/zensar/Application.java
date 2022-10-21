package com.zensar;

 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
 
@SpringBootApplication
@ComponentScan(basePackages = {"com.zensar"})
public class Application {

	public static void main(String[] args) {
		  SpringApplication.run(Application.class, args);
		
		  BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			
			//we are encoding password
			//use encoded password in your configuration file
			System.out.println(passwordEncoder.encode("zensar"));
		
	}

}
