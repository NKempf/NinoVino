package metier;

public class Vin {

	public String id, region, appelation, producteur, millesime;
	public int quantite;
	
	@Override
	public String toString() {
		return "Région : " + region + ", Appelation : "
				+ appelation + "/n producteur : " + producteur + ", Millesime : "
				+ millesime ;
	}


	public Vin(String id, String region, String appelation, String producteur,
			String millesime, int quantite) {
		super();
		this.id = id;
		this.region = region;
		this.appelation = appelation;
		this.producteur = producteur;
		this.millesime = millesime;
		this.quantite = quantite;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getAppelation() {
		return appelation;
	}


	public void setAppelation(String appelation) {
		this.appelation = appelation;
	}


	public String getProducteur() {
		return producteur;
	}


	public void setProducteur(String producteur) {
		this.producteur = producteur;
	}


	public String getMillesime() {
		return millesime;
	}


	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
	
	
}
