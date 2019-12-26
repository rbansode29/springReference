package com.spring.javajee.autoconfig;

import org.springframework.stereotype.Component;

@Component("writer")
public class JJWriterComp {
    public void write() {
        System.out.println("Default Writer");
    }
}
