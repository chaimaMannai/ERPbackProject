package ERP.service;

import java.util.List;
import ERP.dto.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customer);
	List<CustomerDto> getAllCustomers();
	CustomerDto getCustomerById(int id);
	CustomerDto modifyCustomer(int id, CustomerDto customer);
	void deleteCustomerById(int id);
	
	// le client le plus fidele
	CustomerDto getClientFidele();
	
	
	// le nombre des client dans le stock 
	int getTotalNumberclients();
	CustomerDto getCustomerByUserName(String Username);
}
