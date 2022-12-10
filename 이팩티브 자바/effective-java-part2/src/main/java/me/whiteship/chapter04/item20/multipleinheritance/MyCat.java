package me.whiteship.chapter04.item20.multipleinheritance;

public class MyCat extends AbstractCat implements Flyable {

    /**
     * 아래 구현체를 만들고 내부 클래스에 아래와 같이 필드 선언을 하는 것임
     */
    private MyFlyable myFlyable = new MyFlyable();

    @Override
    protected String sound() {
        return "인싸 고양이 두 마리가 나가신다!";
    }

    @Override
    protected String name() {
        return "유미";
    }

    public static void main(String[] args) {
        MyCat myCat = new MyCat();
        System.out.println(myCat.sound());
        System.out.println(myCat.name());
        myCat.fly();
    }

    /**
     * myFlyable 필드한테 fly 를 위임에서 쓴다
     */
    @Override
    public void fly() {
        this.myFlyable.fly();
    }

    /**
     * 원래는 AbstractFlyable 이라는 클래스를 상속 받을려고 했으나 클래스 상속은 한개만 가능하므로
     * AbstractFlyable 의 상위 클래스인 Flyable 을 상속 받아 구현체를 내부에 따로 만들어줌
     * 그게 아래 MyFlyable 임, MyFlyable 은 추상 클래스 AbstractFlyable 를 상속 받고
     */
    private class MyFlyable extends AbstractFlyable {
        @Override
        public void fly() {
            System.out.println("날아라.");
        }
    }
}
