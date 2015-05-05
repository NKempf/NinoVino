package base_donnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AppelationsBDD {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "cave.db";
 
	private static final String TABLE_APPELATIONS = "table_appelations";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NOM = "nom";
	private static final int NUM_COL_nom = 1;
	private static final String COL_IDREG = "IDREG";
	private static final int NUM_COL_IDREG = 0;
 
	private SQLiteDatabase bdd;
 
	private MaCaveSQLite maCaveSQLite;
 
	public AppelationsBDD(Context context){
		//On créer la BDD et sa table
		maCaveSQLite = new MaCaveSQLite(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open(){
		//on ouvre la BDD en écriture
		bdd = maCaveSQLite.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'accès à la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertAppelation(Appelation appelation){
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NOM, appelation.getNom());
		values.put(COL_IDREG, appelation.getId_region());
		//on insère l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_APPELATIONS, null, values);
	}
 
	public int updateAppelation(int id, Appelation appelation){
		//La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
		ContentValues values = new ContentValues();
		values.put(COL_NOM, appelation.getNom());
		values.put(COL_IDREG, appelation.getId_region());
		return bdd.update(TABLE_APPELATIONS, values, COL_ID + " = " +id, null);
	}
 
	public int removeAppelationWithID(int id){
		//Suppression d'une appelation de la BDD grâce à l'ID
		return bdd.delete(TABLE_APPELATIONS, COL_ID + " = " +id, null);
	}
 
	public Appelation getAppelationWithNom(String nom){
		//Récupère dans un Cursor les valeur correspondant à un region contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_APPELATIONS, new String[] {COL_ID, COL_NOM, COL_IDREG}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
		return cursorToAppelation(c);
	}
 
	//Cette méthode permet de convertir un cursor en un appelation
	private Appelation cursorToAppelation(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		c.moveToFirst();
		//On créé un livre
		Appelation appelation = new Appelation();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		appelation.setId(c.getInt(NUM_COL_ID));
		appelation.setNom(c.getString(NUM_COL_nom));
		appelation.setId_region(c.getInt(NUM_COL_IDREG));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return appelation;
	}
}
