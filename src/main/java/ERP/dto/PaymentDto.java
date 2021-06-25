package ERP.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	
	private int id ;
	private String mode ;
	private Date datePayment=new Date(); ;
	private double montant ;
	private InvoiceDto invoice;
	
}