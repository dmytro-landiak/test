package com.landim.lab3.flowers;

public class Tulip extends Flower {

    private String tulipField;

    public Tulip() {
        super();
    }

    public Tulip(double price, int freshness) {
        super(price, freshness);
    }

    public Tulip(double price, int freshness, String tulipField) {
        super(price, freshness);
        setTulipField(tulipField);
    }

    public String getTulipField() {
        return tulipField;
    }

    public final void setTulipField(String tulipField) {
        this.tulipField = tulipField;
    }

    public void doSmthThatTulipDoes() {
        System.out.println("Tulip does this!");
    }

    @Override
    public String toString() {
        return String.format("Tulip \n{\nfreshness: %d, \nprice: %f, \ntulipField: %s\n}",
                getFreshness(), getPrice(), getTulipField());
    }
}
