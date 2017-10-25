package za.co.hlengi;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author hjita
 */


@Entity
@Table(name = "users")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userID;
        
	@Column(name = "email")
	private String email;
 
	@Column(name = "password")
	private String password;
	
	@Column(name = "isAdmin")
	private Boolean isAdmin;
        
	protected User() 
	{
	}
        
	public User(String email, String password, Boolean isAdmin) 
	{
		
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
    public long getUserID() {
		return userID;
	}

	public String getEmail()
    {
        return email;
    }
	    
    public String getPassword()
    {
        return password;
    }
    
    public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
	@Override
	public String toString() {
		return String.format("User [UserID=%d, Email='%s']", userID, email);
	}
}
