package za.co.hlengi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> 
{
	List<User> findByEmail(String email);

}
