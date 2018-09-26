package edu.aachuaumich.cis436_final.Views;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import edu.aachuaumich.cis436_final.DALC.DALC;
import edu.aachuaumich.cis436_final.R;
import edu.aachuaumich.cis436_final.DALC.CartAdapter;
import edu.aachuaumich.cis436_final.Objects.Order;


public class Cart extends AppCompatActivity
{
    SQLiteDatabase db;
    int user = 1;
    DALC mhelper;
    List<Order> orderList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        final Button products = findViewById(R.id.btnProducts);
        final Button checkOut = findViewById(R.id.btnCheckout);

        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                products.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent products = new Intent(Cart.this, Products.class);
                        startActivity(products);
                    }
                });

                checkOut.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        mhelper = new DALC(Cart.this);
                        SQLiteDatabase sqLiteDatabase = mhelper.getWritableDatabase();
                        sqLiteDatabase.delete("cart2","userId = ?", new String[] {String.valueOf(1)});
                        sqLiteDatabase.close();
                        //reload cart
                        Intent cart = new Intent(Cart.this, Cart.class);
                        startActivity(cart);
                        //display toast
                        Toast.makeText(getApplicationContext(), "Order will be delivered soon!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        };

        Thread listenerThread = new Thread (r);
        listenerThread.start();


        //open cosmo.db
        db = openOrCreateDatabase("Cosmo.DB",MODE_PRIVATE,null);

        Thread openDb = new Thread (r);
        openDb.start();

        orderList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.cartList);

        Runnable ran = new Runnable()
        {
            @Override
            public void run()
            {
                loadCart(user);
            }
        };

        Thread load = new Thread(ran);
        load.start();
    }

    private void loadCart(int currentUser)
    {
        //grab cart of current user
        String getCart = "SELECT * FROM cart2 WHERE userId =" + currentUser;
        Cursor cursor = db.rawQuery(getCart,null);

        if(cursor.moveToFirst())
        {
            do{
                orderList.add(new Order(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3)
                ));
            }while (cursor.moveToNext());

            CartAdapter adapter = new CartAdapter(this, R.layout.custom_layout, orderList);
            listView.setAdapter((adapter));
        }
    }

    public void removeItem(String itemDelete)
    {
        mhelper = new DALC(Cart.this);

        SQLiteDatabase sqLiteDatabase = mhelper.getWritableDatabase();
        sqLiteDatabase.delete("cart2","id = ?", new String[] {String.valueOf(itemDelete)});
        sqLiteDatabase.close();
        //reload cart
        Intent cart = new Intent(Cart.this, Cart.class);
        startActivity(cart);
    }
}
