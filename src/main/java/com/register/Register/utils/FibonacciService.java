package com.register.Register.utils;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    private List<Long> fibonacciList = new ArrayList<>();

    public List<Long> getFibonacci(int n) {
        createFibonacciList(n);
        return fibonacciList;
    }



    private void createFibonacciList(int n) {

        if (n >= 0) fibonacciList.add(0L);
        if (n >= 1) fibonacciList.add(1L);

        for (int i = 2; i <= n; i++) {
            long nextFibonacci = getNextFibonacci(fibonacciList, i);
            fibonacciList.add(nextFibonacci);
        }
    }

    private static long getNextFibonacci(List<Long> fibonacciList, int i) {
        return fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
    }
}
