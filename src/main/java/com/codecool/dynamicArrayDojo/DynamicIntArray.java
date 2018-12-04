package com.codecool.dynamicArrayDojo;


import java.util.Arrays;


public class DynamicIntArray {

    private int[] staticArray = new int[0];

    public DynamicIntArray(int initSize) {
        this.staticArray = new int[initSize];
    }

    public DynamicIntArray() {
        this.staticArray = new int[0];
    }

    @Override
    public String toString() {
        String stringify = new String();
        for (int num: this.staticArray) {
            stringify += " " + num;
        }
        return stringify;
    }


    public void add(int num) {
        int[] resizedArray = Arrays.copyOf(this.staticArray, staticArray.length+1);
        resizedArray[staticArray.length] = num;
        this.staticArray = Arrays.copyOf(resizedArray, resizedArray.length);
    }


    public void remove(int removeNum) {
        Arrays.sort(this.staticArray);
        int numIndex = Arrays.binarySearch(this.staticArray, removeNum);
        int oldIndex = 0;
        int counter = 0;
        int[] resizedArray = new int[this.staticArray.length];
        while (numIndex >= 0) {
            counter += 1;
            resizedArray = Arrays.copyOfRange(this.staticArray, oldIndex, numIndex);
            oldIndex = numIndex + 1;
            numIndex = Arrays.binarySearch(this.staticArray, oldIndex, this.staticArray.length, removeNum);
        }
        int [] truncatedArray = new int[this.staticArray.length - counter];
        truncatedArray = Arrays.copyOf(resizedArray, resizedArray.length);
        this.staticArray = Arrays.copyOf(truncatedArray, truncatedArray.length);
    }

    public void insert(int index, int newValue) {
        int[] insertedArray = Arrays.copyOf(this.staticArray, staticArray.length+1);
        insertedArray[index] = newValue;

        for (int newIndex = index + 1; newIndex < insertedArray.length; newIndex++, index++ ) {
            insertedArray[newIndex] = this.staticArray[index];
        }
        this.staticArray = Arrays.copyOf(insertedArray, insertedArray.length);
    }
}



