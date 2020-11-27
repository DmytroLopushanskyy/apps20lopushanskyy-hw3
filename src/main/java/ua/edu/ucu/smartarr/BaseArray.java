package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] wrappee;

    public BaseArray(Object[] integers) {
        this.wrappee = integers.clone();
    }

    @Override
    public Object[] toArray() {
        return wrappee.clone();
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return wrappee.length;
    }
}
