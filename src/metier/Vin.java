package metier;

public class Vin {

	public int id, type, region, appelation, millesime, quantite;
	public String producteur;
	
	public Vin(int id, int type, int region, int appelation, String producteur, int millesime,
			int quantite) {
		super();
		this.id = id;
		this.type = type;
		this.region = region;
		this.appelation = appelation;
		this.millesime = millesime;
		this.quantite = quantite;
		this.producteur = producteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public int getAppelation() {
		return appelation;
	}

	public void setAppelation(int appelation) {
		this.appelation = appelation;
	}

	public int getMillesime() {
		return millesime;
	}

	public void setMillesime(int millesime) {
		this.millesime = millesime;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getProducteur() {
		return producteur;
	}

	public void setProducteur(String producteur) {
		this.producteur = producteur;
	}

	@Override
	public String toString() {
		return "Vin [id=" + id + ", type=" + type + ", region=" + region
				+ ", appelation=" + appelation + ", millesime=" + millesime
				+ ", quantite=" + quantite + ", producteur=" + producteur + "]";
	}
	
	


	
	
	
	
}
