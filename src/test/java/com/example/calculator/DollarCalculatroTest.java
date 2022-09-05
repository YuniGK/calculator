package com.example.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatroTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach//테스트 실행 전
    public void init(){
                        //when - 언제 connect가 호출이 될때 1350을 리턴한다.
        Mockito.lenient().when(marketApi.connect()).thenReturn(1350);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        //MarketApi marketApi = new MarketApi();

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);

        System.out.println(calculator.sum(10, 10));

        //Assertions.assertEquals(26000, calculator.sum(10, 10));
        Assertions.assertEquals(27000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));

    }
}
