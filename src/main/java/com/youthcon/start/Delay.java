package com.youthcon.start;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Delay {
    public Delay() throws InterruptedException {
//        Thread.sleep(10000);
    }
}
