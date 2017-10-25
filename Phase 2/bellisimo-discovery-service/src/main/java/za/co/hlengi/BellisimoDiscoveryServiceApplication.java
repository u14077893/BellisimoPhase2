package za.co.hlengi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BellisimoDiscoveryServiceApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(BellisimoDiscoveryServiceApplication.class, args);
	}
}
