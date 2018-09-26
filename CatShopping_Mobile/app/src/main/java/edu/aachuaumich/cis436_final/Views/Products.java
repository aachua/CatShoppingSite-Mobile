package edu.aachuaumich.cis436_final.Views;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.aachuaumich.cis436_final.DALC.DALC;
import edu.aachuaumich.cis436_final.R;

public class Products extends AppCompatActivity
{
    DALC db;
    int currentUser = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        final Button friskies = findViewById(R.id.btnFriskies);
        final Button fancy = findViewById(R.id.btnFancy);
        final Button purina = findViewById(R.id.btnPurina);
        final Button authority = findViewById(R.id.btnAuthority);
        final Button tower = findViewById(R.id.btnTower);
        final Button bed = findViewById(R.id.btnBed);
        final Button scratch = findViewById(R.id.btnScratch);
        final Button bowl = findViewById(R.id.btnBowl);
        final Button ball = findViewById(R.id.btnBall);
        final Button turtle = findViewById(R.id.btnTurtle);
        final Button pack = findViewById(R.id.btnPack);
        final Button mice = findViewById(R.id.btnMice);
        final Button cart = findViewById(R.id.btnCart);


        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                //make database
                db = new DALC(Products.this);
            }
        };

        Thread dalcThread = new Thread (r);
        dalcThread.start();

        cart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent cart = new Intent(Products.this, Cart.class);
                startActivity(cart);
            }
        });

        friskies.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Friskies Shreds", "1.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        fancy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Fancy feast classic", "2.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        purina.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Purina pro plan", "1.25");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        authority.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Authority", "1.50");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });
        tower.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Cat Tower", "100.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        bed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Cat bed", "25.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        scratch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Scratch post", "15.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        bowl.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Feeding set", "10.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        ball.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Ball tower", "20.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        turtle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Toy turtle", "5.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        pack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Variety pack", "5.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });

        mice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addToCart(currentUser, "Toy mouse", "2.00");
                Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_LONG).show();
            }
        });
    }
}
