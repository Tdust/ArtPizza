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

        btCriar = (Button) findViewById(R.id.btCriar);


        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("nome");
        TextView nome = (TextView) findViewById(R.id.et1);
        nome.setText(parametro);

        btCriar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
                Intent intent = new Intent(MontaPizzaActivity.this, ListaPizzaActivity.class);
                startActivity(intent);
            }
        });
    }
    public void salvar() {

        nome = (EditText) findViewById(R.id.et1);
        preco = (EditText) findViewById(R.id.et2);

        Pizza pizza = new Pizza(nome.getText().toString(), parseFloat(preco.getText().toString()));
        pizza.save();
    }
}
