package org.example;
public class AsientoPremium extends Asiento{
    public AsientoPremium(int num) {
        super(num);
    }
    public String getTipoAsiento(){
        return "Premium";
    }
}

