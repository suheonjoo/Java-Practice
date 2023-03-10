package me.whiteship.designpatterns._02_structural_patterns._12_proxy._02_after;

public class GameServiceProxy implements GameService {

    /**
     * GameService 를 상속 받으면, GameService 를 필드로 가지고 있다
     */
    private GameService gameService; //상속 받은 것을 필드로 가지고 있다


    @Override
    public void startGame() {
        long before = System.currentTimeMillis();
        //여기 예제에서는 Client 가 GameServiceProxy 의 gamService 를 초기화하지 않아서 null 값으로 들어감
        if (this.gameService == null) {
            this.gameService = new DefaultGameService();
        }
        gameService.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
