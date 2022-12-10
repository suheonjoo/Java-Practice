package me.whiteship.chapter04.item18.callback;

public class Service {

    public void run(FunctionToCall functionToCall) {
        System.out.println("뭐 좀 하다가...");
        functionToCall.call();
    }

    public static void main(String[] args) {
        Service service = new Service();
        BobFunction bobFunction = new BobFunction(service);
        BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
        bobFunctionWrapper.run();
        //밥을 먹을까 하고 커피도 먹을까 호출하면 아래처럼 call 을 호출하면 됨
        //bobFunctionWrapper.call();
    }
}
