package edu.aachuaumich.cis436_final.DALC;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;
import java.util.List;
import edu.aachuaumich.cis436_final.Objects.Order;


public class DALC extends SQLiteOpenHelper
{
    private static final String DB_Name = "Cosmo.DB";
    private static final int DB_VER = 1;

    public DALC(Context context)
    {
        super(context, DB_Name, null, DB_VER);
        onCreate(getWritableDatabase());
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //when activity is created, make new table in cosmo.db
        String sqlCart = "CREATE TABLE IF NOT EXISTS cart2(id INTEGER PRIMARY KEY AUTOINCREMENT, userId int, productName VARCHAR, price VARCHAR);";
        //String test = "DROP TABLE cart";
        sqLiteDatabase.execSQL(sqlCart);
    }

    public boolean addToCart(int user, String name, String price)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", user);
        contentValues.put("productName", name);
        contentValues.put("price", price);
        db.insert("cart2", null, contentValues);
        db.close();
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        String dropCart = "DROP TABLE IF EXISTS cart2";

        sqLiteDatabase.execSQL(dropCart);

        onCreate(sqLiteDatabase);
    }
}
