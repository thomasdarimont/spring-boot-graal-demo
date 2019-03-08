package demo;

import java.time.Instant;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootHelloWorld {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorld.class, args);
	}
}

@RestController
@RequestMapping("/")
class HelloController {

	@GetMapping
	Object getData() {
		return Collections.singletonMap("greeting", "Hello " + Instant.now());
	}
}
