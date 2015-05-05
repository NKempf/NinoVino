package base_donnees;

public class Millesime {

	/**
	 * Création d'un Millésime
	 */
	 
		private int id;
		private String annee;
	 
		//getters et Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		 
		public String getAnnee() {
			return annee;
		}

		public void setAnnee(String annee) {
			this.annee = annee;
		}

		//Constructeurs
		public Millesime() {}

		public Millesime(int id,String annee) {
			super();
			this.annee = annee;
			this.id=id;
		}

		@Override
		public String toString() {
			return "Millesime [id=" + id + ", année=" + annee + "]";
		}
		
		// tostring
		
	
}