package base_donnees;

public class Region {  
	 
	/**
	 * Création d'un Région
	 */
	 
		private int id;
		private String nom;
	 
		public Region(){}
	 
		public Region(int id, String nom){
			this.nom = nom;
			this.id=id;
		}
	 
	
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
	 
		public String toString(){
			return "ID : "+id+"\nNom : "+nom;
		}
	}