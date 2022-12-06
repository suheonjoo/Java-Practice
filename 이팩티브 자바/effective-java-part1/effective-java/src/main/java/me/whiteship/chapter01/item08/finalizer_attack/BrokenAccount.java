package me.whiteship.chapter01.item08.finalizer_attack;

import java.math.BigDecimal;

public class BrokenAccount extends Account {

    /**
     * Account 를 상속을 받고 부모의 생성자 호출하도록 함
     * 그러면 예외가 발생할 것임
     * @param accountId
     */
    public BrokenAccount(String accountId) {
        super(accountId);
    }

    @Override
    protected void finalize() throws Throwable {
        this.transfer(BigDecimal.valueOf(100), "keesun");
    }
}

