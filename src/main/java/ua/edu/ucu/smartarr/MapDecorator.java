package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    public  MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);

        Object[] newArr = smartArray.toArray();

        // Map the array
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = func.apply(newArr[i]);
        }

        this.smartArray = new BaseArray(newArr);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator used";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
