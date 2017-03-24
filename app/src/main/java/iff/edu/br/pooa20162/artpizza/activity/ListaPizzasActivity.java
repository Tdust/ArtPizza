package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.adapter.PizzaAdapter;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

public class ListaPizzasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pizzas);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaPizzasActivity.this,MontaPizzaActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
        ListView lista = (ListView) findViewById(R.id.lvPizza);

        final ArrayList<Pizza> pizzas = (ArrayList<Pizza>)
                Pizza.listAll(Pizza.class);

        ArrayAdapter adapter = new PizzaAdapter(this, pizzas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaPizzasActivity.this,MontaPizzaActivity.class);

                intent.putExtra("id",pizzas.get(i).getId().intValue());
                intent.putExtra("nome",pizzas.get(i).getNome());
                intent.putExtra("preco",pizzas.get(i).getPreco());

                startActivity(intent);
            }
        });

    }
}
