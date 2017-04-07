package com.landim.lab3.flowers;


public class Camomile extends Flower {

    private String camomileField;

    public Camomile() {
        super();
    }

    public Camomile(double price, int freshness) {
        super(price, freshness);
    }

    public Camomile(double price, int freshness, String camomileField) {
        super(price, freshness);
        setCamomileField(camomileField);
    }

    public String getCamomileField() {
        return camomileField;
    }

    public final void setCamomileField(String camomileField) {
        this.camomileField = camomileField;
    }

    public void doSmthThatCamomileDoes() {
        System.out.println("Camomile does this!");
    }

    @Override
    public String toString() {
        return String.format("Camomile \n{\nfreshness: %d, \nprice: %f, \ncamomileField: %s\n}",
                getFreshness(), getPrice(), getCamomileField());
    }
}
