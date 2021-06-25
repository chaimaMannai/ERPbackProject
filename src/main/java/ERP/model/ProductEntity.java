package ERP.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Products")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Description;
	private double PriceVente;
	private double priceAchat;
	private boolean statuts;
	private String image ;
	private int quantite;
	private String category;
	
	////@ManyToOne
    //""@Column(insertable=true, updatable=true)
	///////private CategoryEntity category;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private List<LineSaleEntity> lineSales= new ArrayList<>();
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private List<BuyLineEntity> lineBuys= new ArrayList<>();

	public String getName() {
		return Name;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isStatuts() {
		return statuts;
	}

	public void setStatuts(boolean statuts) {
		this.statuts = statuts;
	}

	public double getPriceAchat() {
		return priceAchat;
	}

	public void setPriceAchat(double priceAchat) {
		this.priceAchat = priceAchat;
	}

	public double getPriceVente() {
		return PriceVente;
	}

	public void setPriceVente(double priceVente) {
		this.PriceVente = priceVente;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	

}