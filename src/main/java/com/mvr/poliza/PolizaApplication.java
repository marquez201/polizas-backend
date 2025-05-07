package com.mvr.poliza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class PolizaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolizaApplication.class, args);
	}

}
