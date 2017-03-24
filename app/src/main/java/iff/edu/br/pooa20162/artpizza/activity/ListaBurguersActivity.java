package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.adapter.BurguerAdapter;
import iff.edu.br.pooa20162.artpizza.model.Burguer;

public class ListaBurguersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_burguers);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaBurguersActivity.this, MontaBurguerActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);

            }
        });
        ListView lista = (ListView) findViewById(R.id.lvBurguer);

        final ArrayList<Burguer> burgs = (ArrayList<Burguer>)
                Burguer.listAll(Burguer.class);

        ArrayAdapter adapter = new BurguerAdapter(this, burgs);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaBurguersActivity.this, MontaBurguerActivity.class);

                intent.putExtra("id",burgs.get(i).getId().intValue());
                intent.putExtra("nome",burgs.get(i).getNome());
                intent.putExtra("preco",burgs.get(i).getPreco());

                startActivity(intent);
            }
        });
    }

}
