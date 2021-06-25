package ERP.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ERP.dto.CustomerDto;
import ERP.dto.ProductDto;
import ERP.model.CustomerEntity;
import ERP.model.OrderSaleEntity;
import ERP.model.ProductEntity;
import ERP.repository.CustomerRepository;
import ERP.repository.OrderSaleRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository reposCustomer;
	private OrderSaleRepository reposOrderSale;
	private ModelMapper mapper;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository reposCustomer ,OrderSaleRepository reposOrderSale ,ModelMapper mapper) {
		super();
		this.reposCustomer = reposCustomer;
		this.reposOrderSale = reposOrderSale;
		this.mapper = mapper;
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customer) {
		CustomerEntity entity=mapper.map(customer, CustomerEntity.class);
		CustomerEntity newEntity=reposCustomer.save(entity);
		/*if(entity.getSalesOrders()!=null) {
			for(OrderSaleEntity order :entity.getSalesOrders()) {
				order.setCustomer(entity);
		        reposOrderSale.save(order);		
		       
			}
		}*/
		return mapper.map(newEntity, CustomerDto.class);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto>listCustomerDto =new ArrayList<>();
		List<CustomerEntity>listCustomerEntity=reposCustomer.findAll();
		for (CustomerEntity customerEntity : listCustomerEntity) {
			listCustomerDto.add(mapper.map(customerEntity, CustomerDto.class));
		}
		
		
		return listCustomerDto;
	}

	@Override
	public CustomerDto getCustomerById(int id) {
		CustomerEntity entity;
		Optional<CustomerEntity> opt = reposCustomer.findById(id);
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Customer with this id is not found");
		
		return mapper.map(entity, CustomerDto.class);
	}

	@Override
	public CustomerDto modifyCustomer(int id, CustomerDto customer) {
		CustomerEntity entity =reposCustomer.findById(id).get();
		entity.setAddress(customer.getAddress());
		entity.setEmail(customer.getEmail());
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setPhoneNumber(customer.getPhoneNumber());
		entity.setType(customer.getType());
		entity.setUsername(customer.getUsername());
		CustomerEntity newEntity =reposCustomer.save(entity);
		return mapper.map(newEntity, CustomerDto.class);
		
	}

	@Override
	public void deleteCustomerById(int id) {
		reposCustomer.deleteById(id);

	}

	
	// le client le plus fidele
	@Override
	public CustomerDto getClientFidele() {
		int max=0;
		CustomerEntity cutomerPF = null;
		CustomerDto customerPFDto = null;
		List<CustomerEntity> customers =reposCustomer.findAll();
		for (CustomerEntity customer : customers) {
			if(customer.getSalesOrders().size()>max) {
				max = customer.getSalesOrders().size();
				cutomerPF = customer;	
			}
			
		}
		
		customerPFDto = mapper.map(cutomerPF, CustomerDto.class);
		
		return customerPFDto;
	}
	
	// le nombre des client dans le stock 
	@Override
	public int getTotalNumberclients() {
		List<CustomerEntity> customers =reposCustomer.findAll();
		return customers.size();
	}

	@Override
	public CustomerDto getCustomerByUserName(String Username) {
		CustomerEntity customerEntitytrouvable=null;
		List<CustomerEntity>listCustomerEntity=reposCustomer.findAll();
		
		for (CustomerEntity customerEntity : listCustomerEntity) {
			if(customerEntity.getUsername().equalsIgnoreCase(Username))
			{
				customerEntitytrouvable=customerEntity;
				break;
			}
		}
		
		return mapper.map(customerEntitytrouvable, CustomerDto.class);
		
	}

}
