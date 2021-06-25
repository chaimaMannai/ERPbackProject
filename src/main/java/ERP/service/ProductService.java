package ERP.service;

import java.util.List;

import ERP.dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto product);
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	ProductDto modifyProduct(int id, ProductDto product);
	void deleteProductyById(int id);
	
	// le produit le plus achete
	ProductDto getProductlePlusAchete();
	
	// le nombre des produits dans le stock
	int getTotalNumberProducts();
	
}
