package iff.edu.br.pooa20162.artpizza.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import iff.edu.br.pooa20162.artpizza.R;
import iff.edu.br.pooa20162.artpizza.model.Bandeja;

/**
 * Created by zelandia on 27/03/2017.
 */

public class BandejaAdapter extends ArrayAdapter<Bandeja> {

    private Context context = null;
    private ArrayList<Bandeja> ban = null;

    public BandejaAdapter(Context context, ArrayList<Bandeja> ban) {
        super(context, R.layout.linhab, ban);
        this.context = context;
        this.ban = ban;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhab, parent, false);

        TextView b = (TextView) rowView.findViewById(R.id.bBurg);
        TextView p = (TextView) rowView.findViewById(R.id.bPizza);

        b.setText(ban.get(position).getBurguer().getNome());
        p.setText(ban.get(position).getPizza().getNome());

        return rowView;
    }
}
