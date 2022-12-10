package me.whiteship.chapter05.item28.safevarags;

import java.util.List;

public class SafeVaragsExample {

//    @SafeVarargs // Not actually safe!
    static void notSafe(List<String>... stringLists) {
        Object[] array = stringLists; // List<String>... => List[], 그리고 배열은 공변이니까.
        List<Integer> tmpList = List.of(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    @SafeVarargs
    static <T> void safe(T... values) {
        for (T value: values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        /**
         * 단순히 출려기 기능으로 에러가 안나는 코드
         */
        SafeVaragsExample.safe("a", "b", "c");

        /**
         * 에러가 나는 것
         */
        SafeVaragsExample.notSafe(List.of("a", "b", "c"));
    }

}
