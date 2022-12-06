package me.whiteship.chapter01.item08.cleaner_as_a_safetynet;

/**
 *
 cleaner 안전망을 갖춘 자원을 제대로 활용하는 클라이언트 (45쪽)
 */
public class Adult {
    /**
     * 이렇게 사용해야 함 try resource 로
     * @param args
     */
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("안녕~");
        }
    }
}
