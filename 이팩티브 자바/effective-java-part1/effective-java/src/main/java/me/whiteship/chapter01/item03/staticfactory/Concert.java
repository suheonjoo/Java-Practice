package me.whiteship.chapter01.item03.staticfactory;

import java.util.function.Supplier;

public class Concert {

    /**
     * 장점 3. “정적 팩터리의 메서드 참조”를 공급자(Supplier)로 사용할 수 있다.
     * @param singerSupplier
     */
    public void start(Supplier<Singer> singerSupplier) {
        Singer singer = singerSupplier.get();
        singer.sing();
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        /**
         * 일허게 메서드 참고로 인자(getInstance)를 넘겨주고
         * start에서는 받은 인자로 .get()인 함수형 인터페이스의 메서드를 호출해서 Singer를 가져오고 .sing() 메서드를 호출하는 것임
         */
        concert.start(Elvis::getInstance);
        /**
         * 위에 같은 거임 이렇게 람다를 사용해서 쓸수 있음!
         */
        concert.start(()-> Elvis.getInstance());
        /**
         * 이렇게 익명 내부 클래스로도 할수 있음 -> 자바8부터 람다 식으로 쓸수 있는 것임
         */
        concert.start(new Supplier<Singer>() {
            @Override
            public Singer get() {
                return Elvis.getInstance();
            }
        });
    }
}
