package base_donnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Bdd extends SQLiteOpenHelper{

	
//TUTO : http://a-renouard.developpez.com/tutoriels/android/sqlite/
//	TUTO ANGLAIS : http://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
	private static final int DATABASE_VERSION = 4;
	private static final String DATABASE_NAME = "notrecave";
	
	// Déclarations des constantes pour les différentes tables de la base
	private static final String TABLE_REGION = "region";
	private static final String COL_REG_ID = "id_reg";
	private static final String COL_REG_NOM = "nom";
	private static final String TABLE_MILL = "millesime";
	private static final String COL_MILL_ID = "id_mill";
	private static final String COL_MILL_ANNEE = "annee";	
	private static final String TABLE_APP = "appelation";
	private static final String COL_APP_ID = "id_app";
	private static final String COL_APP_NOM = "nom";
	private static final String TABLE_TYPE = "type";
	private static final String COL_TYPE_ID = "id_type";
	private static final String COL_TYPE_NOM = "nom";	
	private static final String TABLE_VIN = "vin";
	private static final String COL_VIN_ID = "id_vin";
	private static final String COL_VIN_PROD = "producteur";
	private static final String COL_VIN_QUANTI = "quantite";	
	
	
	
	private static final String CREATE_BDD_REGION = "CREATE TABLE "+TABLE_REGION+" ("
			+COL_REG_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COL_REG_NOM +" TEXT);";
	
	
	private static final String CREATE_BDD_MILL = "CREATE TABLE "+TABLE_MILL+" ("
			+COL_MILL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ COL_MILL_ANNEE+" TEXT);";
	
	private static final String CREATE_BDD_VIN = "CREATE TABLE " + TABLE_VIN + " ("
			+ COL_VIN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COL_TYPE_ID + " INTEGER, "
			+ COL_REG_ID + " INTEGER, "
			+ COL_APP_ID + " INTEGER, "
			+ COL_VIN_PROD + " TEXT NOT NULL, "
			+ COL_MILL_ID + " INTEGER, "
			+ COL_VIN_QUANTI + " INTEGER );";
	
	
	private static final String CREATE_BDD_APP = "CREATE TABLE " + TABLE_APP + " ("
			+ COL_APP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COL_APP_NOM + " TEXT NOT NULL, "
			+ COL_REG_ID + " INTEGER );";
	
	private static final String CREATE_BDD_TYPE = "CREATE TABLE " + TABLE_TYPE + " ("
			+ COL_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COL_TYPE_NOM + " TEXT NOT NULL);";
	
	public Bdd(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		// chargerBase();
				
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
//		db.execSQL("CREATE TABLE vin (id TEXT PRIMARY KEY, nom TEXT, region TEXT, id_appelation TEXT FOREIGN KEY,"
//				+ " producteur TEXT, id_millesime TEXT FOREIGN KEY, id_type TEXT FOREIGN KEY, quantite INTEGER)");
//		db.execSQL("CREATE TABLE appelation (id TEXT PRIMARY KEY, nom TEXT, id_region TEXT FOREIGN KEY)");
		db.execSQL(CREATE_BDD_REGION);
		db.execSQL(CREATE_BDD_MILL);
		db.execSQL(CREATE_BDD_APP);
		db.execSQL(CREATE_BDD_TYPE);
		db.execSQL(CREATE_BDD_VIN);
			}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_REGION );
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_MILL);
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_APP);
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_TYPE);
		db.execSQL("DROP TABLE IF EXISTS  " + TABLE_VIN);
		onCreate(db);
		
	}
	
	// Méthodes d'insertion dans les tables 
	
	public long insertion_region (String region){
		SQLiteDatabase writableDB = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_REG_NOM,region);
		long rowId = writableDB.insert(TABLE_REGION, null, values);
		return rowId;
	}
	
	public long insertion_Mill (String annee){
		SQLiteDatabase writableDB = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_MILL_ANNEE,annee);
		long rowId = writableDB.insert(TABLE_MILL, null, values);
		return rowId;
	}
	
	public long insertion_Appel (String nom, int id_reg){
		SQLiteDatabase writableDB = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_APP_NOM,nom);
		values.put(COL_REG_ID,id_reg);
		long rowId = writableDB.insert(TABLE_APP, null, values);
		return rowId;	
	}
	
	public long insertionType (String nom){
		SQLiteDatabase writableDB = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_TYPE_NOM,nom);
		long rowId = writableDB.insert(TABLE_TYPE, null, values);
		return rowId;	
	}
	
	public long insertionVin (int id_type, int id_reg, int id_app, String producteur, int id_mill, int quantite){
		SQLiteDatabase writableDB = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_TYPE_ID,id_type);
		values.put(COL_REG_ID,id_reg);
		values.put(COL_APP_ID,id_app);
		values.put(COL_VIN_PROD,producteur);
		values.put(COL_MILL_ID,id_mill);
		values.put(COL_VIN_QUANTI,quantite);
		long rowId = writableDB.insert(TABLE_VIN, null, values);
		return rowId;	
	}
	
		
		
}
