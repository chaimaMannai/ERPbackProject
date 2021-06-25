package ERP.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderSaleDto {

	private int number;
    private Date date = new Date();
    private float totalPrice;
    
    //
    private boolean valid=false;
 
    private CustomerDto customer;
    
    private InvoiceDto invoice;

   
}