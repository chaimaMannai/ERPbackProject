package ERP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ERP.dto.ProductDto;
import ERP.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRest {
 
	private ProductService service;
	
	
    @Autowired
	public ProductRest(ProductService service) {
		super();
		this.service = service;
	}
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
	public ProductDto createProduct( @RequestBody ProductDto product) {
		
		return service.createProduct(product);
	}
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
	public List<ProductDto> getAllProducts() {
		return service.getAllProducts();
	}
    
    @GetMapping("/{id}")
	public ProductDto getProductById(@PathVariable("id") int id) {
    	return service.getProductById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteProductyById(@PathVariable("id") int id)
    {
    	service.deleteProductyById(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
	public ProductDto modifyProduct(@PathVariable("id") int id,@RequestBody ProductDto product) {
	    return	service.modifyProduct(id, product);}
    
	// le produit le plus achete
    @GetMapping("/LeplusAchete")
    public ProductDto getProductlePlusAchete() {
    	return service.getProductlePlusAchete();
    }
    
    @GetMapping("/TotalProducts")
    public int getNumberProducts() {
    	return service.getTotalNumberProducts();
    }
}
