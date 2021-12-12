package com.youthcon.start;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelayController {
    public DelayController() throws InterruptedException {
        Thread.sleep(5000);
    }
}
