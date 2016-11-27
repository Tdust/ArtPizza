package iff.edu.br.pooa20162.artpizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button montaBurguer = (Button) findViewById(R.id.btMontaBurguer);
        montaBurguer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MontaBurguerActivity.class);
                //intent.putExtra("nome", etNome.getText().toString());
                startActivity(intent);
            }
        });
    }
}
