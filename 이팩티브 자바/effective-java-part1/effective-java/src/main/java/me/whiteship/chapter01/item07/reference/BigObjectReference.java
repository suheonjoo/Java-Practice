package me.whiteship.chapter01.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class BigObjectReference<BigObject> extends PhantomReference<BigObject> {

    /**
     * 이거 자동 생성으로 만들어준거임 PhantomReference 이거 상속 받으면 빨강 밑줄 생겨서 option enter 로 만들어줌
     * @param referent
     * @param q
     */
    public BigObjectReference(BigObject referent, ReferenceQueue<? super BigObject> q) {
        super(referent, q);
    }

    public void cleanUp() {
        System.out.println("clean up");
    }
}
