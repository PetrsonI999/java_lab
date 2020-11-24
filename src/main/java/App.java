import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static <T1 extends Number, T2 extends Number> void printUniqueValues(List<T1> numberList1, List<T2> numberList2) {
        System.out.println("print unique values");
        List<Number> uniqueValues = getUniqueValues(numberList1, numberList2);
        System.out.println(uniqueValues);
    }

    private static <T1 extends Number, T2 extends Number> List<Number> getUniqueValues(List<T1> numberList1, List<T2> numberList2) {
        List<Number> uniqueValues = new ArrayList<>();

        List<Number> List1UniqueValues = numberList1.stream()
                .filter(number -> !numberList2.contains(number))
                .collect(Collectors.toList());

        List<Number> List2UniqueValues = numberList2.stream()
                .filter(number -> !numberList1.contains(number))
                .collect(Collectors.toList());

        uniqueValues.addAll(List1UniqueValues);
        uniqueValues.addAll(List2UniqueValues);

        return uniqueValues;
    }

    private static <T1 extends Number, T2 extends Number> void printNumberUniqueValues(List<T1> numberList1, List<T2> numberList2) {
        System.out.println("print unique numbers");
        List<Number> uniqueValues = getNumberUniqueValues(numberList1, numberList2);
        System.out.println(uniqueValues);
    }

    private static <T1 extends Number, T2 extends Number> List<Number> getNumberUniqueValues(List<T1> numberList1, List<T2> numberList2) {
        List<Number> uniqueValues = new ArrayList<>();

        List<Double> numberList1Double = numberList1.stream()
                .map(Number::doubleValue).collect(Collectors.toList());

        List<Double> numberList2Double = numberList2.stream()
                .map(Number::doubleValue).collect(Collectors.toList());

        List<Number> List1UniqueValues = numberList1Double.stream()
                .filter(number -> !numberList2Double.contains(number))
                .collect(Collectors.toList());

        List<Number> List2UniqueValues = numberList2Double.stream()
                .filter(number -> !numberList1Double.contains(number))
                .collect(Collectors.toList());

        uniqueValues.addAll(List1UniqueValues);
        uniqueValues.addAll(List2UniqueValues);

        return uniqueValues;
    }


}
