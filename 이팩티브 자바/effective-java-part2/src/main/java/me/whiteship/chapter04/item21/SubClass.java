package me.whiteship.chapter04.item21;

public class SubClass extends SuperClass implements MarkerInterface {

    public static void main(String[] args) {
        /**
         * 클래스와 인터페이스 우선순위 경쟁을 하면 클래스가 항상 이긴다
         * 그래서 subClass 의 hello 호출시 SuperClass(이긴 클래스) 의 hello 호출하려고 하나
         * private 이기에 에러가 난다
         */
        SubClass subClass = new SubClass();
        subClass.hello();
    }

}
