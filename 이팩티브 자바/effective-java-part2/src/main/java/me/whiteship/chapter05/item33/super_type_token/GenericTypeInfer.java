package me.whiteship.chapter05.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {

    static class Super<T> {
        T value;
    }

    static class Sub extends Super<String> {
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Super<String> stringSuper = new Super<>();
        System.out.println(stringSuper.getClass().getDeclaredField("value").getType());

        // Sub sub = new Sub();
        // Type type = sub.getClass().getGenericSuperclass();
        Type type = (new Super<String>(){}).getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        Type actualTypeArgument = pType.getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);

    }
}
