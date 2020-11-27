package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);

        // First we determine the size of the new array
        int counter = getNewSize();

        // Create this array
        Object[] newArr = createArray(counter);

        this.smartArray = new BaseArray(newArr);
    }

    private int getNewSize() {
        Object[] presentArr = smartArray.toArray();
        int counter = 0;
        for (int i = 0; i < presentArr.length; i++) {
            boolean isInArray = false;
            for (int j = 0; j < i; j++) {
                if (presentArr[i].equals(presentArr[j])) {
                    isInArray = true;
                    break;
                }
            }
            if (!isInArray) {
                counter++;
            }
        }
        return counter;
    }

    private Object[] createArray(int size) {
        Object[] newArr = new Object[size];

        // Write data
        Object[] presentArr = smartArray.toArray();
        int counter = 0;
        for (int i = 0; i < presentArr.length; i++) {
            boolean isInArray = false;
            for (int j = 0; j < i; j++) {
                if (presentArr[i].equals(presentArr[j])) {
                    isInArray = true;
                    break;
                }
            }
            if (!isInArray) {
                newArr[counter] = presentArr[i];
                counter++;
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
        return "DistinctDecorator used";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
