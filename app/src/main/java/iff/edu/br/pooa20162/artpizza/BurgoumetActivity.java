package iff.edu.br.pooa20162.artpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BurgoumetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burgoumet);

        //recebendo os valores da outra tela
        Intent intent = getIntent();
        Bandeja prato = new Bandeja();
        Burguer lanche = new Burguer();
        lanche.setNome((String) intent.getSerializableExtra("nome"));
        //prato.setBandeja((Burguer[]) intent.getSerializableExtra("bandejos"));
        lanche.setPreco((float) intent.getSerializableExtra("preco"));



        final TextView txvNome = (TextView)findViewById(R.id.txvNomeBurguer);
        final TextView txvPreco = (TextView)findViewById(R.id.txvPrecoBurguer);

        txvNome.setText("Chegou como "+lanche.getNome());
        txvPreco.setText("Valor atual R$ "+lanche.getPreco()+"0");
    }
}