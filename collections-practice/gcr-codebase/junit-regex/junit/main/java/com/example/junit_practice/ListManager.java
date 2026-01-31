package com.example.junit_practice;
import java.util.List;

public class ListManager {

    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element); 
        }
    }

    public void removeElement(List<Integer> list, int element) {
        if (list != null) {
            // We cast to Integer to ensure we remove the object, not the index
            list.remove(Integer.valueOf(element));
        }
    }

    public int getSize(List<Integer> list) {
        return (list == null) ? 0 : list.size();
    }
}