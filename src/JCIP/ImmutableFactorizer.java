package JCIP;

import Hard.ByteDanceQuickSort;

public class ImmutableFactorizer {


    public static final ByteDanceQuickSort sol;
    public static final String HELLO = "HELLO";
    static {
        System.out.println("static block inited");
        sol = new ByteDanceQuickSort();
    }
}
