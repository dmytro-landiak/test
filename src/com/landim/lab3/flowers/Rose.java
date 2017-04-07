package com.landim.lab3.flowers;

public class Rose extends Flower {

    private String roseField;

    public Rose() {
        super();
    }

    public Rose(double price, int freshness) {
        super(price, freshness);
    }

    public Rose(double price, int freshness, String roseField) {
        super(price, freshness);
        setRoseField(roseField);
    }

    public String getRoseField() {
        return roseField;
    }

    public final void setRoseField(String roseField) {
        this.roseField = roseField;
    }

    public void doSmthThatRoseDoes() {
        System.out.println("Rose does this!");
    }

    @Override
    public String toString() {
        return String.format("Rose \n{\nfreshness: %d, \nprice: %f, \nroseField: %s\n}",
                getFreshness(), getPrice(), getRoseField());
    }

}
