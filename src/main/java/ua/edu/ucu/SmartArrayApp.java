package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;

public class SmartArrayApp {
    public static Integer[]
        filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
        findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                Student[] students) {
        // Select those who are 2nd year students
        MyPredicate select2ndYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2
                        && ((Student) t).getGPA() >= 4;
            }
        };

        // To String
        MyFunction objToString = new MyFunction() {
            @Override
            public Object apply(Object st) {
                return ((Student) st).getSurname() + " " + ((Student) st).getName();
            }
        };

        // Sort by Surname
        MyComparator cmpBySurname = new MyComparator() {
            @Override
            public int compare(Object st1, Object st2) {
                return ((Student) st1).getSurname()
                        .compareTo(((Student) st2).getSurname());
            }
        };

        SmartArray studSmartArray = new BaseArray(students);

        studSmartArray = new FilterDecorator(studSmartArray, select2ndYear);
        studSmartArray = new SortDecorator(studSmartArray, cmpBySurname);
        studSmartArray = new MapDecorator(studSmartArray, objToString);

        // Select distinct
        studSmartArray = new DistinctDecorator(studSmartArray);

        Object[] result = studSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
