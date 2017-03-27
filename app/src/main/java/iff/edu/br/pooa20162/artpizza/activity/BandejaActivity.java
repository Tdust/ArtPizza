package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.model.Bandeja;
import iff.edu.br.pooa20162.artpizza.model.Burguer;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

public class BandejaActivity extends AppCompatActivity {

    Spinner spP, spB;
    Button btCriar, btSalvar;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandeja);

        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");

        final ArrayList<Burguer> burg  = (ArrayList) Burguer.listAll(Burguer.class);

        ArrayAdapter<Burguer> adapterB = new ArrayAdapter<Burguer>(this, android.R.layout.simple_spinner_item, burg);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spB = (Spinner) findViewById(R.id.spinB);
        spB.setAdapter(adapterB);

        final ArrayList<Pizza> piz  = (ArrayList) Pizza.listAll(Pizza.class);

        ArrayAdapter<Pizza> adapterP = new ArrayAdapter<Pizza>(this, android.R.layout.simple_spinner_item, piz);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spP = (Spinner) findViewById(R.id.spinP);
        spP.setAdapter(adapterP);

        btCriar = (Button) findViewById(R.id.btCriarBand);
        btSalvar = (Button) findViewById(R.id.btSalvarBand);

        if (id != 0) {
            btCriar.setEnabled(false);
            btCriar.setClickable(false);
            btCriar.setVisibility(View.INVISIBLE);

        } else {
            btSalvar.setEnabled(false);
            btSalvar.setClickable(false);
            btSalvar.setVisibility(View.INVISIBLE);
        }

        btCriar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Burguer b = ((Burguer) spB.getSelectedItem());
                Pizza p = ((Pizza) spP.getSelectedItem());

                Bandeja band = new Bandeja(p,b);
                band.save();
                Intent intent = new Intent(BandejaActivity.this, ListaBandejaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bandeja band = Bandeja.findById(Bandeja.class, id);

                band.setBurguer((Burguer) spB.getSelectedItem());
                band.setPizza((Pizza) spP.getSelectedItem());
                band.save();
                finish();
            }
        });
    }
}
