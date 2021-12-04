package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] array;


    public ArrayUtility(T[] array) {
        this.array = array;
    }


    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        //given two arrays
        //count the # of occurrences to evaluate
        //we would need to loop through both arrays
        //get the count from the first array
        //get the count from the second array
        //return the total number of times it occurs in both arrays

        int counter = 0;
        for (T element : array) {
            if (element.equals(valueToEvaluate)) {
                counter++;
            }
        }
        for (T element : arrayToMerge) {
            if (element.equals(valueToEvaluate)) {
                counter++;
            }
        }
        return counter;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        //given two arrays
        //count the common value that occurs between the two arrays
        //loop thru two arrays
        //return the value that occurs the most

        //tracks our current index;
        int counter = 0;
        //variable that contain the most common element
        T mostCommonElement = null;
        //created a new HashMap that has a SomeType object key, and an integer value called frequency
        Map<T, Integer> frequency = new HashMap<>();
        //loop the first array
        for (T element : array) {
            //take our map, for every element it updates our map with the key and update the counter of value +1
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
            //current count of the elements occurring through the array
            int currentCount = frequency.get(element);
            //if the current frequency is greater than  the counter
            if (currentCount > counter) {
                //take that current count and put into the counter
                counter = currentCount;
                //the current element will than be initialized with the mostCommonElement
                mostCommonElement = element;
            }
        }
        for (T element : arrayToMerge) {
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
            int currentCount = frequency.get(element);
            if (currentCount > counter) {
                counter = currentCount;
                mostCommonElement = element;

            }
        }

        return mostCommonElement;
    }

    public int getNumberOfOccurrences(T valueToEvaluate) {
        //given array
        //return the number of times the value occurrences

        int counter = 0;
        for (T element : array) {
            if (element.equals(valueToEvaluate)) {
                counter++;
            }
        }

        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        //create a new array --> that is an arrayList
        //place all the elements that does not match the valueToRemove into our arrayList
        //return the arrayList --> an array

        //counter that takes in the previous method
        int removeCounter = getNumberOfOccurrences(valueToRemove);
        int counter = 0;
        //create a copy of the original array, with the length - remove
        T[] arrayWithRemovedElements = Arrays.copyOf(this.array, this.array.length - removeCounter);
        for (T element : array) {
            if (!element.equals(valueToRemove)) {
                //new array at the index of counter will be the element we're copying
                arrayWithRemovedElements[counter++] = element;
            }
        }
        return arrayWithRemovedElements;

    }
}

