package me.whiteship.chapter01.item03.staticfactory;

import java.util.Objects;

/**
 * 코드 3-2 제네릭 싱글톤 팩토리 (24쪽)
 * @param <T>
 */
public class MetaElvis<T> {

    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis() { }

    /**
     * 원하는 타입으로 형변환 해줄수 있다는 장점
     * @param <E>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <E> MetaElvis<E> getInstance() { return (MetaElvis<E>) INSTANCE; }

    public void say(T t) {
        System.out.println(t);
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        /**
         * 이렇게 원하는 타입으로 바꿔서 쓸수 있음 -> 이게 제네릭 팩토리의 장점임
         */
        MetaElvis<String> elvis1 = MetaElvis.getInstance();
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();

        System.out.println(elvis1);
        System.out.println(elvis2);
        elvis1.say("hello");
        elvis2.say(100);
    }

}
