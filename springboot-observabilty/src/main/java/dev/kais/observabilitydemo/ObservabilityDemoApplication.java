package dev.kais.observabilitydemo;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


import dev.kais.observabilitydemo.post.JsonPlaceholderService;
import dev.kais.observabilitydemo.post.Post;
import io.micrometer.observation.annotation.Observed;

@SpringBootApplication
public class ObservabilityDemoApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
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

	@Observed(name = "posts.load-all-posts", contextualName = "post.find-all" )
	@Bean
	CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService)
	{
		return args -> {
			List<Post> posts = jsonPlaceholderService.findAll();
            log.info("Posts : {}",posts.size());
		};
	}
	
	
	
	
}












