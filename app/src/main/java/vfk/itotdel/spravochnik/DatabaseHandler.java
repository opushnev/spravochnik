package vfk.itotdel.spravochnik;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by opushnev_nv on 01.11.2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "OS";

    // Contacts table name
    private static final String TABLE_INVENTAR = "inventarnik";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_INVENT = "invent";
    private static final String KEY_BARCODE = "barcode";
    private static final String KEY_COUNT = "count";
    private static final String KEY_ADRES = "adres";
    private static final String KEY_USER = "user";
    private static final String KEY_DESCR = "desc";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_INVENTAR + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TYPE + " INTEGER," + KEY_INVENT + " INTEGER,"+KEY_BARCODE + " TEXT,"+KEY_COUNT + " INTEGER"+KEY_ADRES + " TEXT,"+KEY_USER + " TEXT,"+KEY_DESCR + " TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INVENTAR);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(inventarnik inv) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, inv.getName());
        values.put(KEY_INVENT, inv.getInvent());
        values.put(KEY_ADRES, inv.getAdres());
        values.put(KEY_BARCODE, inv.getBarcode());
        values.put(KEY_COUNT, inv.getCount());
        values.put(KEY_DESCR, inv.getDesc());
        values.put(KEY_TYPE, inv.getType());
        values.put(KEY_USER, inv.getUser());

        db.insert(TABLE_INVENTAR, null, values);
        db.close();
    }

    // Getting single contact
    /*getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }
*/
    // Getting All Contacts
    public List<inventarnik> getAllInventarniki() {
        List<inventarnik> contactList = new ArrayList<inventarnik>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_INVENTAR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                inventarnik contact = new inventarnik();
                contact.setType(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setInvent(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }
/*
    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
*/
}
