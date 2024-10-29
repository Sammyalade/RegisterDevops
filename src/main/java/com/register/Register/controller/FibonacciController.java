package com.register.Register.controller;

import com.register.Register.utils.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/{number}")
    public List<Long> getFibonacci(@PathVariable int number) {
        return fibonacciService.getFibonacci(number);
    }
}
