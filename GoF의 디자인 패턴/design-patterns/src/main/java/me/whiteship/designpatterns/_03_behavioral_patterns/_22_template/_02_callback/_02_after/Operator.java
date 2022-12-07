package me.whiteship.designpatterns._03_behavioral_patterns._22_template._02_callback._02_after;

/**
 * 여기서 이거를 함수혀 인터페이스로 사용한 것임
 */
public interface Operator {

    abstract int getResult(int result, int number);
}
