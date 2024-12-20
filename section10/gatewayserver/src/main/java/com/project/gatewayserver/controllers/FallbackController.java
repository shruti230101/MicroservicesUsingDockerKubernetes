package com.project.gatewayserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @RequestMapping("/contactSupport")
    public ResponseEntity<Mono<String>> contactSupport() /* throws InterruptedException */ {
//        Thread.sleep(5000);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Mono.just("An error occurred. Please try again after some time or contact Support Team."));
    }
}