package me.whiteship.chapter05.item30._01_before;

import java.util.HashSet;
import java.util.Set;

// 제네릭 union 메서드와 테스트 프로그램 (177쪽)
public class Union {

    // 코드 30-2 제네릭 메서드 (177쪽)
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // 서로 다른 제네릭 타입으로 메개변수를 받을수 있나? 안됨 ㅎ
    // public static void union(Set<E> s1, Set<D> s2) {
    //     System.out.println(s1);
    //     System.out.println(s2);
    // }

    // 코드 30-3 제네릭 메서드를 활용하는 간단한 프로그램 (177쪽)
    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
//        Set<Integer> stooges = Set.of(1, 2, 3);
        Set<String> all = union(guys, stooges);

        for (String o : all) {
            System.out.println(o);
        }
    }
}
