package supcom.projetdevmob.com.collegementor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_dateofbirth = "dateofbirth";
    private static final String COLUMN_password = "password";
    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (firstname text not null , lastname text not null , email text not null ,dateofbirth text not null ,password text not null);";

    SQLiteDatabase db;

    public database(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }

    public void insertuser(USER user) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRSTNAME, user.getFirstname());
        values.put(COLUMN_LASTNAME, user.getLastname());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_password, user.getPassword());
        values.put(COLUMN_dateofbirth, user.getDateofbirth());
        db.insert(TABLE_NAME, null, values);
        db.close();


    }

    public boolean searchname(String email) {


        db = this.getReadableDatabase();
        String query = "select email from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String gettedemail;

        if(cursor.getCount()==0){return false ; }else{



        if (cursor != null) {
            cursor.moveToFirst();


            do {
                gettedemail = cursor.getString(0);
                if (gettedemail.equals(email)) {
                    return true;
                }

            } while (cursor.moveToNext());


            return false;

        }
        return false;
    }}

    public boolean searchpass(String email, String password) {

        db = this.getReadableDatabase();
        String query = "select email,password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String gettedemail;
        String gettedpassword;
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                gettedemail = cursor.getString(0);
                if (gettedemail.equals(email)) {
                    gettedpassword = cursor.getString(1);
                    if (gettedpassword.equals(password)) {
                        return true;
                    } else return false;
                }

            } while (cursor.moveToNext());

        }
        return false;

    }


    public USER getuser(String email) {
        USER user = new USER();
        db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                String myemail = cursor.getString(2);
                if (email.equals(myemail)) {
                    user.setFirstname(cursor.getString(0));
                    user.setLastname(cursor.getString(1));
                    user.setEmail(cursor.getString(2));
                    user.setDateofbirth(cursor.getString(3));
                    user.setPassword("x");
                    return user;
                }

            } while (cursor.moveToNext());

        }

        return user ;
    }



}