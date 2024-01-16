package dev.kais.observabilitydemo.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping("")
	public String sayHello()
	{
		return "<h1>HELLO HOME !</h1>";
	}
	
}
