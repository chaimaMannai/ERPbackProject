package ERP.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="Payment")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String mode ;
	private Date datePayment =new Date() ;
	private double montant ;
	
	
	@ManyToOne
	private InvoiceEntiy invoice ;


	

}