package Lecture_5.FilterCollection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FilterColl {

    @Test
    public void testFilterCollection() {
        List<Integer> listOfNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(0);
            add(-1);
            add(10);
            add(11);
            add(-20);
            add(40);

        }};

        //all>0
        System.out.println("Элементы коллекции больше 0:");
        listOfNumbers.stream().filter(s -> s > 0).forEach(s -> System.out.print(s + " "));
        System.out.println();
        //all<0
        System.out.println("Элементы коллекции меньше 0:");
        listOfNumbers.stream().filter(s -> s < 0).forEach(s -> System.out.print(s + " "));
        System.out.println();
        //all%5==0
        System.out.println("Элементы коллекции кратные 5:");
        listOfNumbers.stream().filter(s -> (s % 5) == 0).forEach(s -> System.out.print(s + " "));
        System.out.println();
        //all%10==0
        System.out.println("Элементы коллекции кратные 10:");
        listOfNumbers.stream().filter(s -> (s % 10) == 0).forEach(s -> System.out.print(s + " "));


    }

}
