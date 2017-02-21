package iff.edu.br.pooa20162.artpizza.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.model.Pizza;

/**
 * Created by zelandia on 21/02/2017.
 */

public class PizzaAdapter extends ArrayAdapter<Pizza>
{
    private Context context = null;
    private ArrayList<Pizza> pizzas = null;


    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas) {
        super(context, R.layout.linhapizza, pizzas);
        this.context = context;
        this.pizzas = pizzas;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhapizza, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.pNome);
        TextView preco = (TextView) rowView.findViewById(R.id.pPreco);


        nome.setText(pizzas.get(position).getNome());
        preco.setText(Float.toString(pizzas.get(position).getPreco()));

        return rowView;
    }
}
