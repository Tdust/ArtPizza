package iff.edu.br.pooa20162.artpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MontaBurguerActivity extends AppCompatActivity {

    void adicionar(String adicional)
    {
        String msg = adicional+" adicionado";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
    void remover(String adicional)
    {
        String msg = adicional+" removido";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    void checarAdicional(CheckBox c, String s)
    {
        if (c.isChecked())
        {   adicionar(s);              }
        else
        {   remover(s);                }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monta_burguer);



        final CheckBox bacon = (CheckBox)findViewById(R.id.cbBaconB);
        final CheckBox queijo = (CheckBox)findViewById(R.id.cbQueijoB);
        final CheckBox presunto = (CheckBox)findViewById(R.id.cbPresuntoB);
        final CheckBox ovo = (CheckBox)findViewById(R.id.cbOvoB);
        final CheckBox frango = (CheckBox)findViewById(R.id.cbFrangoB);

        bacon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checarAdicional(bacon, "Bacon");
            }
        });
        queijo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checarAdicional(queijo,"Queijo");
            }
        });
        presunto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checarAdicional(presunto,"Presunto");
            }
        });
        ovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                checarAdicional(ovo, "Ovo");
            }
        });
        frango.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checarAdicional(frango,"Frango");
            }
        });
    }
}
