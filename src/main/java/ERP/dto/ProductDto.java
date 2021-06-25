package ERP.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProductDto {
	
	private int id;
	@NotBlank(message ="le prenom ne doit pas être vide")
	private String Name;
	
	private String Description;
	@Positive
	private double PriceVente;
	@Positive
	private double priceAchat;
	private boolean statuts;
	private String image ;
	@Positive
	private int quantite;
	
	private String category;
    
	//private CategoryDto category;


	public int getId() {
		return id;
	}


	/*public CategoryDto getCategory() {
		return category;
	}


	public void setCategory(CategoryDto category) {
		this.category = category;
	}*/


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


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		this.Name = name;
	}


	public void setId(int id) {
		this.id = id;
	}
}
