package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.adapter.PizzaAdapter;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

public class ListaPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pizza);

        ListView lista = (ListView) findViewById(R.id.lvPizza);

        final ArrayList<Pizza> pizzas = (ArrayList<Pizza>)
                Pizza.listAll(Pizza.class);

        ArrayAdapter adapter = new PizzaAdapter(this, pizzas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaPizzaActivity.this,MontaPizzaActivity.class);

                intent.putExtra("id",pizzas.get(i).getId().intValue());
                intent.putExtra("nome",pizzas.get(i).getNome());
                intent.putExtra("preco",pizzas.get(i).getPreco());

                startActivity(intent);
            }
        });
        Button novaPizza = (Button) findViewById(R.id.btNovaPizza);
        novaPizza.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ListaPizzaActivity.this,MontaPizzaActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }
    }
