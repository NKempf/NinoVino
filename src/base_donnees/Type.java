package base_donnees;

public class Type {

	/**
	 * Création d'un Type de vin
	 */
	 
		private int id;
		private String type;
		
		//getters et setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		//constructeurs
		
		public Type() {};
	
		public Type(int id,String type) {
			super();
			this.type = type;
			this.id=id;
		}
		
		//ToString
		@Override
		public String toString() {
			return "Type [id=" + id + ", type=" + type + "]";
		}
	
		
		
		
		
		
		
	
}
