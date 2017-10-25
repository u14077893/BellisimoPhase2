
package za.co.hlengi;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@RestController
public class CatalogueService
{
	@Autowired
	private DiscoveryClient discoveryClient;
	
	protected RestTemplate restTemplate = new RestTemplate();
	
	//Products
	@RequestMapping("/loadCatalogue")
	public ResponseEntity<String> loadCatalogue() 
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCTS-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/findAll";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		
		return response;
	}
	
	@RequestMapping("/loadFood")
	public ResponseEntity<String> loadFood() 
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCTS-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/findByCategory/category=food";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		
		return response;
	}
	
	@RequestMapping("/loadClothes")
	public ResponseEntity<String> loadClothes() 
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCTS-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/findByCategory/category=clothes";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		
		return response;
	}
	
	@RequestMapping("/searchCatalogueID")
	public ResponseEntity<String> searchByID(String searchtext)
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCTS-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/findByID/id=" + searchtext;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		
		return response;
	}
	
	@RequestMapping("/searchCatalogueName")
	public ResponseEntity<String> searchByName(String searchtext)
	{
		List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCTS-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/findByName/name=" + searchtext;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		
		return response;
		
	}
	
	
	//Users
	/*@RequestMapping
	public JSONObject getUser()
	{
	
	}
	
	public Boolean checkPassword()
	{
		
	}*/
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}