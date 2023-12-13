package ru.geekbrains.hometask6;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> list1 = new ListIntegerGenerator().generate(20, 1, 10);
        List<Integer> list2 = new ListIntegerGenerator().generate(20, 1, 10);

        System.out.println(list1);
        System.out.println(list2);

        ListAvgComparator avgComparator = new ListAvgComparator(list1, list2);
        avgComparator.showAverage();
        avgComparator.viewComparison();
    }

}
