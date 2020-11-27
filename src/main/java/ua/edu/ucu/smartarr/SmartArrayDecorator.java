package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    private SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public SmartArray getSmartArray() {
        return this.smartArray;
    }

    public void setSmartArray(SmartArray smartArr) {
        this.smartArray = smartArr;
    }
}
