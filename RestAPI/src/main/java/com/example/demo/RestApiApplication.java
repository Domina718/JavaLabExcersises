package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.model.Device;
import com.example.demo.model.Measuring;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.MeasuringRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class RestApiApplication implements CommandLineRunner{

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	MeasuringRepository measuringRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		TypeReference<List<Measuring>> typeReference = new TypeReference<>() {};
		List<Measuring> measurings = objectMapper.readValue(new File("src/main/resources/measurings.json"), typeReference);
		for (Measuring m: measurings) {
			Client client = m.getClient();
			Device device = m.getDevice();

			deviceRepository.save(device);
			clientRepository.save(client);
			measuringRepository.save(m);
		}
	}
}
