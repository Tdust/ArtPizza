package iff.edu.br.pooa20162.artpizza.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

public class Burguer extends SugarRecord implements Parcelable
{

    String nome = "";
    boolean frango=false;
    boolean queijo=false;
    boolean ovo=false;
    boolean presunto=false;
    boolean bacon=false;
    float preco = 4;

    protected Burguer(Parcel in) {
        nome = in.readString();
        frango = in.readByte() != 0;
        queijo = in.readByte() != 0;
        ovo = in.readByte() != 0;
        presunto = in.readByte() != 0;
        bacon = in.readByte() != 0;
        preco = in.readFloat();
    }

    public static final Creator<Burguer> CREATOR = new Creator<Burguer>() {
        @Override
        public Burguer createFromParcel(Parcel in) {
            return new Burguer(in);
        }

        @Override
        public Burguer[] newArray(int size) {
            return new Burguer[size];
        }
    };

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
        else if( isBacon() && isOvo() && isPresunto() && isQueijo() && isFrango())
        {
            nome = ("Galis tudo");
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

    public String toString(){
        return this.nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeByte((byte) (frango ? 1 : 0));
        dest.writeByte((byte) (queijo ? 1 : 0));
        dest.writeByte((byte) (ovo ? 1 : 0));
        dest.writeByte((byte) (presunto ? 1 : 0));
        dest.writeByte((byte) (bacon ? 1 : 0));
        dest.writeFloat(preco);
    }
}
