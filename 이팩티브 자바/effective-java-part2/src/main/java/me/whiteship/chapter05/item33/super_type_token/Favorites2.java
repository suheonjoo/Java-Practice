package me.whiteship.chapter05.item33.super_type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Favorites2 {

    private final Map<TypeRef<?>, Object> favorites = new HashMap<>();

    public <T> void put(TypeRef<T> typeRef, T thing) {
        favorites.put(typeRef, thing);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(TypeRef<T> typeRref) {
        return (T)(favorites.get(typeRref));

        /**
         * 이것도 안전하지는 않음 어쟀든 Class<T> 로 캐스팅을 하는데 이부분도 체크하고 캐스하느게 아여서 그러하다
         */
        // return ((Class<T>)typeRref.getType()).cast(favorites.get(typeRref));

    }

    public static void main(String[] args) {
        Favorites2 f = new Favorites2();

        /**
         * new TypeRef<>() {} 을 보면 익명 구현체임!!!! 생성자 아님!!!
         * TypeRef을 우리가 추상클래스로 선언했잖음 그러니 구현체가 필요하지
         */
        TypeRef<List<String>> stringTypeRef = new TypeRef<>() {};
        System.out.println(stringTypeRef.getType());

        TypeRef<List<Integer>> integerTypeRef = new TypeRef<>() {};
        System.out.println(integerTypeRef.getType());

        f.put(stringTypeRef, List.of("a", "b", "c"));
        f.put(integerTypeRef, List.of(1, 2, 3));
        f.get(stringTypeRef).forEach(System.out::println);
        f.get(integerTypeRef).forEach(System.out::println);
    }
}