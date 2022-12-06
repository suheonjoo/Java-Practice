package me.whiteship.chapter01.item07.executor;

import me.whiteship.chapter01.item01.Product;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 쓰레드는 개수만큼 메모리를 먹음 그래서 삐르다고 무작정 많이 생성하는 것은 안 좋음
         * 여기서 newFixedThreadPool는 쓰레드 풀 개수를 정해서 10개까지만 쓰레드를 만들어 실행시키는 것임
         */
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<String> submit = service.submit(new Task());

        System.out.println(Thread.currentThread() + " hello");

        System.out.println(submit.get());

        /**
         * 이걸 해야 실행이 멈충
         */
        service.shutdown();
    }

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }


}
