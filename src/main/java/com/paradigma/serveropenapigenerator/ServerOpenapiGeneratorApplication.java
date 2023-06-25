package com.paradigma.serveropenapigenerator;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.PetsApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ServerOpenapiGeneratorApplication {

	private final String basePath ="http://localhost:8080";
	public static void main(String[] args) {
		SpringApplication.run(ServerOpenapiGeneratorApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("hello world, I have just started up");
		new PetsApi(new ApiClient().setBasePath(basePath));
		printPets();
	}

	private void printPets() {


		PetsApi apiInstance = new PetsApi(new ApiClient().setBasePath(basePath));

		apiInstance.listPets(20).toStream().forEach(pet -> System.out.println(pet.toString()));


	}

}
