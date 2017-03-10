package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

import static java.lang.Float.parseFloat;

public class MontaPizzaActivity extends AppCompatActivity {

    EditText nome, preco;
    Button btCriar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monta_pizza);

        Intent intent = getIntent();
        int id = (int) intent.getSerializableExtra("id");
        if (id!=0)
        {
            String nomep = (String) intent.getSerializableExtra("nome");
            TextView nome = (TextView) findViewById(R.id.etNomePizza);
            nome.setText(nomep);
            float precop = (float) intent.getSerializableExtra("preco");
            TextView preco = (TextView) findViewById(R.id.etPrecoPizza);
            preco.setText(Float.toString(precop));
        }
        btCriar = (Button) findViewById(R.id.btCriar);
        btCriar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
                Intent intent = new Intent(MontaPizzaActivity.this, ListaPizzaActivity.class);
                startActivity(intent);
            }
        });
    }
    public void salvar(){

        nome = (EditText) findViewById(R.id.etNomePizza);
        preco = (EditText) findViewById(R.id.etPrecoPizza);

        Pizza pizza = new Pizza(nome.getText().toString(), parseFloat(preco.getText().toString()));
        pizza.save();
    }
}
