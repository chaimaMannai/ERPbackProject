package ERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ERP.model.CustomerEntity;






public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{
	

}
