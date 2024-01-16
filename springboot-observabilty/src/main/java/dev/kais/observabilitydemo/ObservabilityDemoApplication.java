package dev.kais.observabilitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


import dev.kais.observabilitydemo.post.JsonPlaceholderService;

@SpringBootApplication
public class ObservabilityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilityDemoApplication.class, args);
	}

	@Bean
	JsonPlaceholderService jsonPlaceholderService() {
		RestClient restClient = RestClient.create("https://jsonPLaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(JsonPlaceholderService.class);

	}

}












