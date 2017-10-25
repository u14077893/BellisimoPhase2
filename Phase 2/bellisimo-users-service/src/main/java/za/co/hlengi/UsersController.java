package za.co.hlengi;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UsersController 
{
	
	protected UsersRepository repository;
	
	@Autowired
	public UsersController(UsersRepository repository)
	{
		this.repository = repository;
	}
	
	@RequestMapping("/addUser")
	public Boolean addUser(@RequestParam("user") JSONObject user)
	{	
		try {
			repository.save(new User(user.getString("email"), user.getString("password"), user.getBoolean("isAdmin")));
		} catch (JSONException e) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("/deleteUser")
	public Boolean removeUser(@RequestParam("id") Long userID)
	{
		repository.delete(userID);
		return true;
	}
	
	@RequestMapping("/updateUser")
	public Boolean updateUser(@RequestParam("id") Long userID, @RequestParam("user") JSONObject user)
	{
		repository.delete(userID);
		try {
			repository.save(new User(user.getString("email"), user.getString("password"), user.getBoolean("isAdmin")));
		} catch (JSONException e) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("/findAll")
	public List<JSONObject> findAllUsers()
	{
		List<JSONObject> result = new ArrayList<JSONObject>();
		
		for(User user: repository.findAll())
		{
			JSONObject userObj = new JSONObject();
			try {
				userObj.put("id", user.getUserID());
				userObj.put("email", user.getEmail());
				userObj.put("password", user.getPassword());
				userObj.put("admin", user.getIsAdmin());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result.add(userObj);
			
		}
		
		return result; 
	}
	
	@RequestMapping("findByEmail")
	public List<JSONObject> findUserByEmail(@RequestParam("email") String email)
	{
		List<JSONObject> result = new ArrayList<JSONObject>();
		
		for(User user: repository.findByEmail(email))
		{
			JSONObject userObj = new JSONObject();
			try {
				userObj.put("id", user.getUserID());
				userObj.put("email", user.getEmail());
				userObj.put("password", user.getPassword());
				userObj.put("admin", user.getIsAdmin());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result.add(userObj);
		}
		
		return result; 
	}
	

}
