package me.whiteship.chapter01.item03.field;

import java.io.Serializable;

// 코드 3-1 public static final 필드 방식의 싱글턴 (23쪽)
public class Elvis implements IElvis, Serializable {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis() {
        /**
         * 질렬화 예제 돌릴때이거 없어야 함 아니면 에러안뜸!
         * 역직렬화 할때 이미 인스턴스가 만들어져 있으니깐 예외가 난도 생각할수 있는데
         * 에러 안뜨는거 보니깐 역직렬화 할때 아예 객체를 새로 만들어서 created 가 false 인 것임
         */
        if (created) {
            throw new UnsupportedOperationException("can't be created by constructor.");
        }

        created = true;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public void sing() {
        System.out.println("I'll have a blue~ Christmas without you~");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    /**
     * 이걸 사용해서 역질렬과를 해도 현재 인스턴스를 반화하도록하는 것임
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
