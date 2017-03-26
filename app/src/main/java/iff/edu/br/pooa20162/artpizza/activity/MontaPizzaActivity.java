package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

import static java.lang.Float.parseFloat;

public class MontaPizzaActivity extends AppCompatActivity {

    EditText nome;
    Button btCriar, btSalvar;
    String tam, pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monta_pizza);

        Intent intent = getIntent();
        final int id = (int) intent.getSerializableExtra("id");

        Spinner spinner = (Spinner) findViewById(R.id.spinTamanho);
        tam = spinner.getSelectedItem().toString();

        int spinner_pos = spinner.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.size_values);
        pre = String.valueOf(size_values[spinner_pos]);

        btCriar = (Button) findViewById(R.id.btCriar);
        btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar(id);
                Intent intent = new Intent(MontaPizzaActivity.this, ListaPizzasActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btCriar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
                Intent intent = new Intent(MontaPizzaActivity.this, ListaPizzasActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if (id!=0)
        {
            String nomep = (String) intent.getSerializableExtra("nome");
            TextView nome = (TextView) findViewById(R.id.etNomePizza);
            nome.setText(nomep);
            btCriar.setEnabled(false);
            btCriar.setClickable(false);
            btCriar.setVisibility(View.INVISIBLE);
        }
        else
        {
            btSalvar.setEnabled(false);
            btSalvar.setClickable(false);
            btSalvar.setVisibility(View.INVISIBLE);
        }

    }
    public void salvar(){

        nome = (EditText) findViewById(R.id.etNomePizza);

        Pizza pizza = new Pizza(nome.getText().toString(), parseFloat(pre));
        pizza.save();
    }
    public void alterar(int id)
    {
        nome = (EditText) findViewById(R.id.etNomePizza);

        Pizza pizza = Pizza.findById(Pizza.class, id);

        pizza.setNome(nome.getText().toString());
        pizza.setPreco(parseFloat(pre));
        pizza.save();
    }
}