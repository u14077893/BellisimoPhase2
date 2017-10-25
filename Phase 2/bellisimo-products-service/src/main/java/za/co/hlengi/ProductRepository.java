package za.co.hlengi;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>
{
	List<Product> findByName(String name);
	List<Product> findByCategory(String category);

}
