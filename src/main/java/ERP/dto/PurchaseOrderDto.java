package ERP.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDto {
	
	private int number;
	//private int total;
	private Date date = new Date();
	private float totalPrice;
	 private boolean valid=false;
	private ProviderDto provider ;   
	private InvoiceDto invoice;
	

}
