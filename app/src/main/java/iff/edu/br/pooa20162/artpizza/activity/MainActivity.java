package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import iff.edu.br.pooa20162.artpizza.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button montaBurguer = (Button) findViewById(R.id.btMontaBurguer);
        montaBurguer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MontaBurguerActivity.class);
                startActivity(intent);
            }
        });

        Button montaPizza = (Button) findViewById(R.id.btMontaPizza);
        montaPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MontaPizzaActivity.class);
                startActivity(intent);
            }
        });

        Button lista = (Button) findViewById(R.id.button);
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ListaPizzaActivity.class);
                startActivity(intent);
            }
        });
    }
}
