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
//commande achat
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//Commande d'achat
@Table(name="PurchaseOrder")
public class PurchaseOrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	//private int total;
	private Date date = new Date();
	private float totalPrice;
	
	private boolean valid=false;
	
	/*@ManyToOne
	private UserEntity user ;*/
	
	@ManyToOne
	private ProviderEntity provider ;
	
	@OneToMany(mappedBy = "purchaseOrder",cascade = CascadeType.REMOVE)
	private List<BuyLineEntity> lineBuys= new ArrayList<>();
   
	@OneToOne(cascade = CascadeType.REMOVE)
	private InvoiceEntiy invoice;

	
}