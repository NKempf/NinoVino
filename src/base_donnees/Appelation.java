package base_donnees;

public class Appelation {
		 
		/**
		 * Création d'une appelation
		 */
		 
			private int id;
			private String nom;
			private int id_region;
			
			// Getters et setters
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getNom() {
				return nom;
			}
			public void setNom(String nom) {
				this.nom = nom;
			}
			public int getId_region() {
				return id_region;
			}
			public void setId_region(int id_region) {
				this.id_region = id_region;
			}
			
			//Constructeur
			
			public Appelation() {};
						
			public Appelation(int id,String nom, int id_region) {
				super();
				this.nom = nom;
				this.id_region = id_region;
				this.id=id;
			}
			
			// Tostring
			@Override
			public String toString() {
				return "Appelation [id=" + id + ", nom=" + nom + ", id_region="
						+ id_region + "]";
			}
		 
			
			
		}