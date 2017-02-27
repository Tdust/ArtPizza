package iff.edu.br.pooa20162.artpizza.model;

import com.orm.SugarRecord;

public class Burguer extends SugarRecord
{

    String nome = "hamburguer";
    boolean frango=false;
    boolean queijo=false;
    boolean ovo=false;
    boolean presunto=false;
    boolean bacon=false;
    float preco = 4;

    public String getNome()
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public boolean isQueijo()
    {
        return queijo;
    }
    public void setQueijo()
    {
        this.queijo = !this.queijo;
    }
    public boolean isOvo()
    {
        return ovo;
    }
    public void setOvo()
    {
        this.ovo = !this.ovo;
    }
    public boolean isPresunto()
    {
        return presunto;
    }
    public void setPresunto()
    {
        this.presunto = !this.presunto;
    }
    public boolean isBacon()
    {
        return bacon;
    }
    public void setBacon()
    {
        this.bacon = !this.bacon;
    }
    public boolean isFrango()
    {
        return frango;
    }
    public void setFrango()
    {
        this.frango = !this.frango;
    }
    public float getPreco()
    {
        return preco;
    }
    public void setPreco(float preco)
    {
        this.preco = preco;
    }

    public String geraNome()
    {
        /*if( isBacon() || isOvo() || isFrango() || isPresunto() || isQueijo() )
        {
            nome = "burguer";
        }*/
        if (isBacon())
        {   nome = "Bacon " + nome;
            this.preco+=1;
        }
        if (isPresunto())
        {
            nome = "Presunto " + nome;
            this.preco+=1;
        }
        if (isOvo())
        {
            nome = "Eggs " + nome;
            this.preco+=1;
        }
        if (isQueijo())
        {
            nome = "X " + nome;
            this.preco+=1;
        }
        if (isFrango())
        {   nome = "Galis " + nome;
            this.preco+=0.5;
        }
        if (this.getPreco()<5.5 && this.getPreco()>4)
        {
            nome = nome + "burguer";
        }
        else if( isBacon() && isOvo() && isPresunto() && isQueijo() )
        {
            nome = ("X tudo");
        }
        if (this.getPreco()<4.5)
        {
            nome = "Hamburguer";
        }
        return this.nome;
    }


    public Burguer(boolean queijo, boolean ovo, boolean presunto, boolean bacon, boolean frango)
    {
        this.bacon = bacon;
        this.presunto = presunto;
        this.ovo = ovo;
        this.queijo = queijo;
        this.frango = frango;
    }

    public Burguer(){}
}
