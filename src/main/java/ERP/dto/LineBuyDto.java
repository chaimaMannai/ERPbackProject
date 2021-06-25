package ERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineBuyDto {
	private int id;
	private int Qt;
	private String description;
	private ProductDto product;
	private PurchaseOrderDto purchaseOrder;
	public int getId() {
		return id;
	}
	public PurchaseOrderDto getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrderDto purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
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
