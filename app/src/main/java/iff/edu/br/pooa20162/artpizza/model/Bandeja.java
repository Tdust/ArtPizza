package iff.edu.br.pooa20162.artpizza.model;

import com.orm.SugarRecord;

import iff.edu.br.pooa20162.artpizza.model.Burguer;

public class Bandeja extends SugarRecord{
    Burguer burguer;
    Pizza pizza;

    public Bandeja() {
    }

    public Bandeja(Pizza pizza, Burguer burguer) {
        this.pizza = pizza;
        this.burguer = burguer;
    }

    public Burguer getBurguer() {
        return burguer;
    }

    public void setBurguer(Burguer burguer) {
        this.burguer = burguer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
