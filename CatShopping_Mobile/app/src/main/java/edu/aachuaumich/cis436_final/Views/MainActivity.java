package edu.aachuaumich.cis436_final.Views;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.aachuaumich.cis436_final.R;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent products = new Intent(MainActivity.this, Products.class);
        startActivity(products);
    }

}
