package base_donnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TypesBDD {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "cave.db";
 
	private static final String TABLE_TYPE = "table_types";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_TYPE = "type";
	private static final int NUM_COL_TYPE = 1;
 
	private SQLiteDatabase bdd;
 
	private MaCaveSQLite maCaveSQLite;
 
	public TypesBDD(Context context){
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
 
	public long insertType(Type type){
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_TYPE, type.getType());
		//on insère l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_TYPE, null, values);
	}
 
	public int updateType(int id, Type type){
		//La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
		ContentValues values = new ContentValues();
		values.put(COL_TYPE, type.getType());
		return bdd.update(TABLE_TYPE, values, COL_ID + " = " +id, null);
	}
 
	public int removeTypeWithID(int id){
		//Suppression d'un livre de la BDD grâce à l'ID
		return bdd.delete(TABLE_TYPE, COL_ID + " = " +id, null);
	}
 
	public Type getTypeWithtype(String type){
		//Récupère dans un Cursor les valeur correspondant à un region contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_TYPE, new String[] {COL_ID, COL_TYPE}, COL_TYPE + " LIKE \"" + type +"\"", null, null, null, null);
		return cursorToType(c);
	}
 
	//Cette méthode permet de convertir un cursor en un type
	private Type cursorToType(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		c.moveToFirst();
		//On créé un livre
		Type type = new Type();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		type.setId(c.getInt(NUM_COL_ID));
		type.setType(c.getString(NUM_COL_TYPE));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return type;
	}
	
	
}
