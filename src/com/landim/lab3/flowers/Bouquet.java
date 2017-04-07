package com.landim.lab3.flowers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bouquet {

    private List<Flower> flowers;


    public final List<Flower> getFlowers() {
        return Collections.unmodifiableList(flowers);
    }

    public void addFlower(Flower flower) {

        if(flowers == null) {
            flowers = new ArrayList<>();
        }
        flowers.add(flower);
    }

    public void sortByFreshness() {
        if(flowers == null)
            throw new IllegalStateException("No such flowers.");

        flowers.sort(Comparator.comparing(Flower::getFreshness));
    }

    public void sortByPrice() {
        if(flowers == null)
            throw new IllegalStateException("No such flowers.");

        flowers.sort(Comparator.comparing(Flower::getPrice));
    }
}
