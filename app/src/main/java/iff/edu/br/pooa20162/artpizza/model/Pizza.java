package iff.edu.br.pooa20162.artpizza.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

/**
 * Created by zelandia on 21/02/2017.
 */

public class Pizza extends SugarRecord implements Parcelable
{
    String nome = "pizza";
    boolean frango=false;
    boolean queijo=false;
    boolean ovo=false;
    boolean presunto=false;
    boolean bacon=false;
    String tamanho;
    float preco = 20;

    public Pizza(boolean frango, boolean queijo, boolean ovo, boolean presunto, boolean bacon, String tamanho) {
        this.frango = frango;
        this.queijo = queijo;
        this.ovo = ovo;
        this.presunto = presunto;
        this.bacon = bacon;
        this.tamanho = tamanho;
    }

    public Pizza() {    }

    public Pizza(String nome, float preco) {
        this.preco = preco;
        this.nome = nome;
    }

    protected Pizza(Parcel in) {
        nome = in.readString();
        frango = in.readByte() != 0;
        queijo = in.readByte() != 0;
        ovo = in.readByte() != 0;
        presunto = in.readByte() != 0;
        bacon = in.readByte() != 0;
        tamanho = in.readString();
        preco = in.readFloat();
    }

    public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
        @Override
        public Pizza createFromParcel(Parcel in) {
            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    public String getNome()
    {        return nome;    }

    public void setNome(String nome)
    {        this.nome = nome;    }

    public boolean isFrango()
    {        return frango;    }

    public void setFrango(boolean frango)
    {        this.frango = frango;    }

    public boolean isQueijo()
    {        return queijo;    }

    public void setQueijo(boolean queijo)
    {        this.queijo = queijo;    }

    public boolean isOvo()
    {        return ovo;    }

    public void setOvo(boolean ovo)
    {        this.ovo = ovo;    }

    public boolean isPresunto()
    {        return presunto;    }

    public void setPresunto(boolean presunto)
    {        this.presunto = presunto;    }

    public boolean isBacon()
    {        return bacon;    }

    public void setBacon(boolean bacon)
    {        this.bacon = bacon;    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPreco()
    {        return preco;    }

    public void setPreco(float preco)
    {        this.preco = preco;     }

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
        dest.writeString(tamanho);
        dest.writeFloat(preco);
    }
}