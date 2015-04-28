package base_donnees;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Bdd extends SQLiteOpenHelper{

	public Bdd(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "mabase";
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE vin (id TEXT PRIMARY KEY,region TEXT, appelation TEXT, producteur TEXT, millesime TEXT, quantite INTEGER)");
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
