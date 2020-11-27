package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] wrappee;

    public BaseArray(Object[] integers) {
        this.wrappee = integers;
    }

    @Override
    public Object[] toArray() {
        return wrappee;
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return wrappee.length;
    }

//    public BaseArray removeElement(int index) {
//        Integer[] newArr = new Integer[wrappee.length - 1];
//
//        int insertCounter = 0;
//        for (int i = 0; i < wrappee.length; i++) {
//            if (i == index) {
//                continue;
//            }
//            newArr[insertCounter] = wrappee[i];
//            insertCounter++;
//        }
//        return newArr;
//    }
}
