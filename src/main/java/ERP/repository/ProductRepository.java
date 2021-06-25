package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.ProductEntity;


public interface ProductRepository  extends JpaRepository<ProductEntity, Integer>{

}
