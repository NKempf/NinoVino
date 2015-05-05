package base_donnees;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class MaCaveSQLite extends SQLiteOpenHelper {
	// variables de la table region
	private static final String TABLE_REGIONS = "table_regions";
	private static final String COL_ID_REG = "ID";
	private static final String COL_NOM_REG = "Nom";
	// variables de la table appelation
	private static final String TABLE_APPELATIONS = "table_appaelations";
	private static final String COL_ID_APP = "ID";
	private static final String COL_NOM_APP = "Nom";
	private static final String COL_IDREG_APP = "IDREG";
//	variables de la table millesimes
	private static final String TABLE_MILLESIMES = "table_mill";
	private static final String COL_ID_MIL = "ID";
	private static final String COL_ANNEE = "annee";
	
	
		
	private static final String CREATE_BDD_REG = "CREATE TABLE " + TABLE_REGIONS + " ("
	+ COL_ID_REG + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
	+ COL_NOM_REG + " TEXT NOT NULL);";
 
	private static final String CREATE_BDD_APP = "CREATE TABLE " + TABLE_APPELATIONS + " ("
			+ COL_ID_APP + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COL_NOM_APP + " TEXT NOT NULL, "
			+ COL_IDREG_APP + "INTEGER FOREIGN KEY);";
	
	
	
	private static final String CREATE_BDD_MIL = "CREATE TABLE " + TABLE_MILLESIMES + " ("
			+ COL_ID_MIL + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COL_ANNEE + " TEXT NOT NULL);";
	
	public MaCaveSQLite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		//on créé la table à partir de la requête écrite dans la variable CREATE_BDD
		db.execSQL(CREATE_BDD_REG);
		db.execSQL(CREATE_BDD_MIL);
//		db.execSQL(CREATE_BDD_APP);
	}
		
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
		//comme ça lorsque je change la version les id repartent de 0
		db.execSQL("DROP TABLE " + TABLE_REGIONS + ";");
		onCreate(db);
	}
 
}
