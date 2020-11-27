package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);

        Object[] newArr = smartArray.toArray();

        // Sort the array
        Arrays.sort(newArr, cmp);

        this.smartArray = new BaseArray(newArr);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator used";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
