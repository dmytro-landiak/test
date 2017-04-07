package com.landim.lab3.flowers;


public abstract class Flower implements Comparable<Flower> {

    private double price;
    private int freshness;

    public Flower() {}

    /**
     * Custom Flower constructor.
     * @param price flower's price.
     * @param freshness flower's freshness. Boundaries of freshness are: [0, 10]. In case when given
     *                  parameter is out of boundaries, lower or higher boundary will be set as value
     *                  of 'freshness' variable.
     */
    public Flower(double price, int freshness) {
        setPrice(price);
        setFreshness(freshness);
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return flower's freshness.
     */
    public int getFreshness() {
        return freshness;
    }

    /**
     *
     * @param freshness flower's freshness. Boundaries of freshness are: [0, 10]. In case when given
     *                  parameter is out of boundaries, lower or higher boundary will be set as value
     *                  of 'freshness' variable.
     */
    public final void setFreshness(int freshness) {
        this.freshness = (freshness > 10) ? 10 : (freshness < 0) ? 0 : freshness;
    }

    @Override
    public final int compareTo(Flower f) {

        // Compare freshness
        int freshnessDifference = this.freshness - f.freshness;
        if (freshnessDifference != 0)
            return freshnessDifference;

        // Compare price
        return Double.compare(this.price, f.price);
    }
}
