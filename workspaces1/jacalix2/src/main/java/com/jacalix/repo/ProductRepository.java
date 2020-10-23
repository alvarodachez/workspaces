package jacalix.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jacalix.model.entity.Product;
@Repository(value = "pr")
public interface ProductRepository extends CrudRepository<Product,Integer>{

}
