package za.co.hlengi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BellisimoCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellisimoCatalogueApplication.class, args);
	}
}
