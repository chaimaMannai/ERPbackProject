package ERP.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Invoice")

public class InvoiceEntiy {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	private Date date = new Date();
	private double totPayments;
	
	
	
	@OneToOne(mappedBy = "invoice")
	private OrderSaleEntity orderSale;
	
	@OneToMany(mappedBy = "invoice",cascade = CascadeType.REMOVE)
	private List<PaymentEntity> payements= new ArrayList<>();
	
	@OneToOne(mappedBy = "invoice")
	private PurchaseOrderEntity purchaseOrder;

	

	public double getTotPayments() {
		return totPayments;
	}

	public void setTotPayments(double totPayments) {
		this.totPayments = totPayments;
	}

	

	
}
