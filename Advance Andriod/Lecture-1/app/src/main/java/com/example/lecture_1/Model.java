package com.example.lecture_1;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private final List<Integer> list;

    public Model() {
        list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
    }

    /**
     * This method take an index and return the value at that index.
     * @param index index
     * @return int
     */
    public int getValueAtIndex(final int index) {
        return list.get(index);
    }

    public void setValueAtIndex(final int index) {
        list.set(index, getValueAtIndex(index) + 1);
        setChanged();
        notifyObservers();
    }
}
