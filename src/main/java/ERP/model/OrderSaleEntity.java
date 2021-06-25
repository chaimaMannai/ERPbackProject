package ERP.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="OrderSale")
// commande vente
public class OrderSaleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	//private int total;
	private Date date = new Date();
	private float totalPrice;
	//
	private boolean valid=false;
	
	@ManyToOne
	private CustomerEntity customer;
	
	/*@ManyToOne
	private UserEntity user;*/
	
	@OneToOne (cascade = CascadeType.REMOVE)
	private InvoiceEntiy invoice;
	
	@OneToMany(mappedBy = "orderSale",cascade = CascadeType.REMOVE)
	private List<LineSaleEntity> lineSales= new ArrayList<>();

	

	

	

}
