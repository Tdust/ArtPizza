package iff.edu.br.pooa20162.artpizza.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.model.Burguer;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

/**
 * Created by zelandia on 27/02/2017.
 */

public class BurguerAdapter extends ArrayAdapter<Burguer> {

    private Context context = null;
    private ArrayList<Burguer> burgueres = null;


    public BurguerAdapter(Context context, ArrayList<Burguer> burgueres) {
        super(context, R.layout.linhaburguer, burgueres);
        this.context = context;
        this.burgueres = burgueres;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaburguer, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.bNome);
        TextView preco = (TextView) rowView.findViewById(R.id.bPreco);

        nome.setText(burgueres.get(position).getNome());
        preco.setText(Float.toString(burgueres.get(position).getPreco()));

        return rowView;
    }
}
