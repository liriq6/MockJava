package webService.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"webService.java.Controller"})
@SpringBootApplication
public class JavaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}
