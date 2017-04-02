package org.stagemonitor.demo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.stagemonitor.core.Stagemonitor;

@SpringBootApplication
@Controller
public class BootZipkinClientApplication {

    @GetMapping("/")
    public ModelAndView home() throws InterruptedException {
        // stagemonitor intercepts the constructor of RestTemplate and adds an interceptor
        // which propagates the tracing context via B3 headers
        final String messageFromServer = new RestTemplate().getForObject("http://localhost:8081", String.class);
        return new ModelAndView("index", "message", messageFromServer);
    }

    public static void main(String[] args) {
        // this is only needed because both the client and the server app are in the same project
        // the default location is stagemonitor.properties
        System.setProperty("stagemonitor.property.overrides", "stagemonitor-client.properties");
        Stagemonitor.init();
        SpringApplication.run(BootZipkinClientApplication.class, args);
    }

}
