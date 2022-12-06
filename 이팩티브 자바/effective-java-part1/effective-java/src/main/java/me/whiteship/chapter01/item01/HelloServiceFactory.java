package me.whiteship.chapter01.item01;

//import me.whiteship.hello.ChineseHelloService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //자바가 기본으로 제공해주는 정적 팩토리 메서드
        // ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        // Optional<HelloService> helloServiceOptional = loader.findFirst();
        // helloServiceOptional.ifPresent(h -> {
        //     System.out.println(h.hello());
        // });

        // HelloService helloService = new ChineseHelloService();
        // System.out.println(helloService.hello());

       Class<?> aClass = Class.forName("me.whiteship.hello.ChineseHelloService");
       Constructor<?> constructor = aClass.getConstructor();
       HelloService helloService = (HelloService) constructor.newInstance();
       System.out.println(helloService.hello());
    }

}
