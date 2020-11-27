package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);

        // First we determine the size of the new array
        int counter = getNewSize(pr);

        // Create this array
        Object[] newArr = createArray(counter, pr);

        this.smartArray = new BaseArray(newArr);
    }

    private int getNewSize(MyPredicate pr) {
        int counter = 0;
        for(Object obj: smartArray.toArray()) {
            if (pr.test(obj)) {
                counter += 1;
            }
        }
        return counter;
    }

    private Object[] createArray(int size, MyPredicate pr) {
        Object[] newArr = new Object[size];

        // Write data
        int counter = 0;
        for(Object obj: smartArray.toArray()) {
            if (pr.test(obj)) {
                newArr[counter] = obj;
                counter += 1;
            }
        }
        return newArr;
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator used";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
