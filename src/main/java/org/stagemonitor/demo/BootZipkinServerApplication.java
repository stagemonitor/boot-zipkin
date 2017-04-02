package org.stagemonitor.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stagemonitor.core.Stagemonitor;

@SpringBootApplication
@RestController
public class BootZipkinServerApplication {

	@GetMapping("/")
	public String sayHello() throws InterruptedException {
		Thread.sleep(500);
		return "Hello from server!";
	}

	public static void main(String[] args) {
		// this is only needed because both the client and the server app are in the same project
		// the default location is stagemonitor.properties
		System.setProperty("stagemonitor.property.overrides", "stagemonitor-server.properties");
		Stagemonitor.init();
		SpringApplication.run(BootZipkinServerApplication.class, "--server.port=8081");
	}
}
