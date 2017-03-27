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
import iff.edu.br.pooa20162.artpizza.adapter.BandejaAdapter;
import iff.edu.br.pooa20162.artpizza.model.Bandeja;

public class ListaBandejaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_bandeja);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaBandejaActivity.this, BandejaActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }
    protected void onResume()
    {
        super.onResume();
        ListView lista = (ListView) findViewById(R.id.lvPedidos);

        final ArrayList<Bandeja> ban = (ArrayList<Bandeja>)
                Bandeja.listAll(Bandeja.class);

        ArrayAdapter adapter = new BandejaAdapter(this, ban);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaBandejaActivity.this, BandejaActivity.class);

                intent.putExtra("id", ban.get(i).getId().intValue());

                startActivity(intent);
            }
        });
    }
}
