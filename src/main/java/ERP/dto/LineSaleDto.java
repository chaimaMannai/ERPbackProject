package ERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineSaleDto {
	private int id;
	private int Qt;
	private String description;
	
	private OrderSaleDto orderSale;
	
	private ProductDto product;

	public int getId() {
		return id;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public OrderSaleDto getOrderSale() {
		return orderSale;
	}

	public void setOrderSale(OrderSaleDto orderSale) {
		this.orderSale = orderSale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQt() {
		return Qt;
	}

	public void setQt(int qt) {
		this.Qt = qt;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
