package org.example;

import org.springframework.stereotype.Service;

@Service  // 이 어노테이션으로 인해 스프링은 컴포넌트 스캔 때 "아 내 컨테이너에 이 클래스를 추가해야겠다" 라고 판단합니다.
public class CalculatorService implements Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나누셨군요? 주먹으로 머리 꽝꽝 때리십쇼");
        }
        return a / b;
    }
}
