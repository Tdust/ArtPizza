package iff.edu.br.pooa20162.artpizza.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import iff.edu.br.pooa20162.artpizza.model.Bandeja;
import iff.edu.br.pooa20162.artpizza.model.Burguer;
import iff.edu.br.pooa20162.artpizza.R;

import static iff.edu.br.pooa20162.artpizza.R.id.txvPreco;
import static java.lang.Float.parseFloat;


public class MontaBurguerActivity extends AppCompatActivity {

    void adicionar(String adicional, boolean b)
    {
        String msg = adicional+" adicionado";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        b = true;
    }
    void remover(String adicional, boolean b)
    {
        String msg = adicional+" removido";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        b = false;
    }

    void checarAdicional(CheckBox c, String s, boolean b)
    {
        if (c.isChecked())
        {   adicionar(s, b);              }
        else
        {   remover(s, b);                }

    }
    void attDados(Burguer burg, TextView tv, TextView txvPreco)
    {
        burg.setNome("");
        burg.setPreco(4);
        burg.geraNome();
        tv.setText(burg.getNome(), null);
        txvPreco.setText("R$ "+Float.toString(burg.getPreco())+"0");
    }

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monta_burguer);

        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");

        final Button bok = (Button)findViewById(R.id.btOK);
        final Button blimpar = (Button)findViewById(R.id.btLimpar);
        final Button bprox = (Button)findViewById(R.id.btContinuar);
        final TextView tv = (TextView)findViewById(R.id.tvResultado);
        final TextView txvPreco = (TextView)findViewById(R.id.txvPreco);
        final Bandeja ban = new Bandeja();

        final Burguer lanche = new Burguer();

        final CheckBox bacon = (CheckBox)findViewById(R.id.cbBaconB);
        final CheckBox queijo = (CheckBox)findViewById(R.id.cbQueijoB);
        final CheckBox presunto = (CheckBox)findViewById(R.id.cbPresuntoB);
        final CheckBox ovo = (CheckBox)findViewById(R.id.cbOvoB);
        final CheckBox frango = (CheckBox)findViewById(R.id.cbFrangoB);

        final boolean ba=false, qu= false, pr=false, eg=false, fr=false;

        bacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checarAdicional(bacon, "Bacon", ba);
                lanche.setBacon();
                attDados(lanche, tv, txvPreco);
            }
        });
        queijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checarAdicional(queijo,"Queijo", qu);
                lanche.setQueijo();
                attDados(lanche, tv, txvPreco);
            }
        });
        presunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checarAdicional(presunto,"Presunto", pr);
                lanche.setPresunto();
                attDados(lanche, tv, txvPreco);
            }
        });
        ovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checarAdicional(ovo, "Ovo", eg);
                lanche.setOvo();
                attDados(lanche, tv, txvPreco);
            }
        });
        frango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checarAdicional(frango,"Frango", fr);
                lanche.setFrango();
                attDados(lanche, tv, txvPreco);
            }
        });

        bok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                alterar(lanche);
            }
        });
        // passando os valores pra outra tela
        bprox.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MontaBurguerActivity.this, ListaBurguersActivity.class);
                attDados(lanche, tv, txvPreco);
                intent.putExtra("nome", lanche.getNome());
                ban.addLanche(lanche);
                //intent.putExtra ("bandejos", ban.bandeja);
                intent.putExtra("preco", lanche.getPreco());
                startActivity(intent);
                salvar(lanche);
                finish();
            }
        });

        blimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tv.setText("Clique em OK para ver o nome do lanche", null);
                lanche.setPreco(0);
                lanche.setNome("");
                txvPreco.setText("R$ "+Float.toString(lanche.getPreco())+"0");
                if(bacon.isChecked())
                {
                    bacon.toggle();
                    lanche.setBacon();
                }
                if(queijo.isChecked())
                {
                    queijo.toggle();
                    lanche.setQueijo();
                }
                if(presunto.isChecked())
                {
                    presunto.toggle();
                    lanche.setPresunto();
                }
                if(ovo.isChecked())
                {
                    ovo.toggle();
                    lanche.setOvo();
                }
                if(frango.isChecked())
                {
                    frango.toggle();
                    lanche.setFrango();
                }
            }
        });
    }
    public void salvar(Burguer a) {
        Burguer burg = new Burguer (a.isQueijo(), a.isOvo(), a.isPresunto(), a.isBacon(), a.isFrango());
        burg.geraNome();
        burg.save();
    }
    public void alterar(Burguer b)
    {
        Burguer burg = Burguer.findById(Burguer.class, id);

        final CheckBox bacon = (CheckBox)findViewById(R.id.cbBaconB);
        final CheckBox queijo = (CheckBox)findViewById(R.id.cbQueijoB);
        final CheckBox presunto = (CheckBox)findViewById(R.id.cbPresuntoB);
        final CheckBox ovo = (CheckBox)findViewById(R.id.cbOvoB);
        final CheckBox frango = (CheckBox)findViewById(R.id.cbFrangoB);

        if (queijo.isChecked());
        {
            if (!burg.isQueijo())
            {   burg.setQueijo();   }
        }
        if (ovo.isChecked());
        {
            if (!burg.isOvo())
            {   burg.setOvo();  }
        }
        if (bacon.isChecked());
        {
            if (!burg.isBacon())
            {   burg.setBacon();    }
        }
        if (presunto.isChecked());
        {
            if(!burg.isPresunto())
            {   burg.setPresunto(); }
        }
        if (frango.isChecked());
        {
            if (!burg.isFrango())
            {   burg.setFrango();   }
        }
        burg.geraNome();
        burg.save();
    }
    public void checaValores(Burguer bur, CheckBox a, CheckBox b, CheckBox c, CheckBox d, CheckBox e)
    {

    }
}
