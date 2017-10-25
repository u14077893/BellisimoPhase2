package za.co.hlengi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class BellisimoProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellisimoProductsServiceApplication.class, args);
	}
}
