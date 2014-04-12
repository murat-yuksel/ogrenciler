package com.muratyuksel.ogrenciler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * DB interactions class
 */
public class dbHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ogrencisistemi";

    // Contacts table name
    private static final String TABLE_OGRENCI = "ogrenciler";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NO = "no";
    private static final String KEY_DATE = "dtarihi";

    public static dbHandler lastDb;


    public dbHandler(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    public static dbHandler getDb(Context context)
    {
        if(lastDb == null)
            lastDb = new dbHandler(context);

        return lastDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_OGRENCI + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_NO + " TEXT," + KEY_DATE + " DATE" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OGRENCI);

        // Create tables again
        onCreate(db);
    }

    public void addOgrenci(Ogrenci ogrenci) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, ogrenci.getName());
        values.put(KEY_NO, ogrenci.getNo());
        values.put(KEY_DATE, ogrenci.getDogumTarihi());

        // Inserting Row
        db.insert(TABLE_OGRENCI, null, values);
        db.close(); // Closing database connection
    }

    public Ogrenci getOgrenci(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_OGRENCI, new String[] { KEY_ID,
                        KEY_NAME, KEY_NO , KEY_DATE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String formatted = sdf.format(new Date(cursor.getString(3)));
        //Log.e("Tarih: ",cursor.getString(3));
        Ogrenci ogrenci = new Ogrenci(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return contact
        return ogrenci;
    }

    public List<Ogrenci> getAllOgrencis() {
        List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_OGRENCI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Ogrenci ogrenci = new Ogrenci();
                ogrenci.setId(Integer.parseInt(cursor.getString(0)));
                ogrenci.setName(cursor.getString(1));
                ogrenci.setNo(cursor.getString(2));
                ogrenci.setDogumTarihi(cursor.getString(3));
                // Adding contact to list
                ogrenciList.add(ogrenci);
            } while (cursor.moveToNext());
        }

        // return contact list
        return ogrenciList;
    }

    public void truncateOgrenci()
    {
        this.onUpgrade(this.getWritableDatabase(), DATABASE_VERSION, DATABASE_VERSION+1);
    }

}
