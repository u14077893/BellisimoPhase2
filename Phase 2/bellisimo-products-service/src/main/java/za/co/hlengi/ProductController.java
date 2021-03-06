package za.co.hlengi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController 
{
	protected ProductRepository repository;

	@Autowired
	public ProductController(ProductRepository repository) 
	{
		this.repository = repository;
	}
	
	@RequestMapping("/addProduct")
	public Boolean addProduct(JSONObject prod)
	{
		try {
			repository.save(new Product(prod.getString("name"), prod.getLong("price"), prod.getString("category"), prod.getString("image")));
		} catch (JSONException e) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("/deleteProduct")
	public Boolean removeProduct(Long prodID)
	{
		repository.delete(prodID);
		return true;
	}
	
	@RequestMapping("/updateProduct")
	public Boolean updateProduct(@RequestParam("id") Long prodID, @RequestParam("product")JSONObject prod)
	{
		repository.delete(prodID);
		try {
			repository.save(new Product(prod.getString("name"), prod.getLong("price"), prod.getString("category"), prod.getString("image")));
		} catch (JSONException e) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("/findAll")
	public List<JSONObject> findAllProd()
	{
		List<JSONObject> result = new ArrayList<JSONObject>();
		for(Product prod: repository.findAll())
		{
			JSONObject prodObj = new JSONObject();
			try {
				prodObj.put("id", prod.getProdID());
				prodObj.put("name", prod.getProdName());
				prodObj.put("image", prod.getProdImage());
				prodObj.put("category", prod.getProdCategory());
				prodObj.put("price", prod.getProdPrice());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result.add(prodObj);
		}
		
		return result; 
	}
	
	@RequestMapping("/findByID")
	public JSONObject findProdByID(@RequestParam("id") long id)
	{
		Product prod = repository.findOne(id);
		JSONObject result = new JSONObject();
		try {
			result.put("id", prod.getProdID());
			result.put("name", prod.getProdName());
			result.put("image", prod.getProdImage());
			result.put("category", prod.getProdCategory());
			result.put("price", prod.getProdPrice());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	
	
	@RequestMapping("/findByName")
	public List<JSONObject> findProdByName(@RequestParam("name") String name)
	{
		List<JSONObject> result = new ArrayList<JSONObject>();
		
		for(Product prod: repository.findByName(name))
		{
			JSONObject prodObj = new JSONObject();
			try {
				prodObj.put("id", prod.getProdID());
				prodObj.put("name", prod.getProdName());
				prodObj.put("image", prod.getProdImage());
				prodObj.put("category", prod.getProdCategory());
				prodObj.put("price", prod.getProdPrice());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result.add(prodObj);
		}
		
		return result; 
	}
	
	@RequestMapping("/findByCategory")
	public List<JSONObject> findProdByCategory(@RequestParam("category") String category)
	{
		List<JSONObject> result = new ArrayList<JSONObject>();
		
		for(Product prod: repository.findByCategory(category))
		{
			JSONObject prodObj = new JSONObject();
			try {
				prodObj.put("id", prod.getProdID());
				prodObj.put("name", prod.getProdName());
				prodObj.put("image", prod.getProdImage());
				prodObj.put("category", prod.getProdCategory());
				prodObj.put("price", prod.getProdPrice());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result.add(prodObj);
		}
		
		return result; 
	}

}
