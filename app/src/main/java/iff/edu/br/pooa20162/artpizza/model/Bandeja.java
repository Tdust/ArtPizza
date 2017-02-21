package iff.edu.br.pooa20162.artpizza.model;

import iff.edu.br.pooa20162.artpizza.model.Burguer;

public class Bandeja {
    int cont = 0;
    transient Burguer bandeja[] = new Burguer[10];

    public Bandeja()
    {}

    public Burguer[] getBandeja() {
        return bandeja;
    }

    public void setBandeja(Burguer[] bandeja) {
        this.bandeja = bandeja;
    }

    public void addLanche(Burguer a)
    {
        bandeja[cont]=a;
        cont++;
    }
    //método colado da net pra ver os paranauês
    public Burguer[] removeLanche(int indice)
    {
        for (int i = 0; i < bandeja.length; i++)
        {
            if (i == indice)
            {
                Burguer[] copy = new Burguer[bandeja.length-1];
                System.arraycopy(bandeja, 0, copy, 0, i);
                System.arraycopy(bandeja, i+1, copy, i, bandeja.length-i-1);
                return copy;
            }
        }
        return bandeja;
    }
}
