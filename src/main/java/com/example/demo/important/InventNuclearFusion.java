package com.example.demo.important;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class InventNuclearFusion {

    boolean fusionScheduledHasRun = false;

    @Scheduled(fixedDelay = Long.MAX_VALUE, initialDelay = 2000)
    public void scheduled() {
        if (!fusionScheduledHasRun) {
            log.info("Scheduled BEGIN");
            fusionScheduledHasRun = true;
            inventFusion();
            log.info("Scheduled END");
        }
    }

    @EventListener
    public void eventListener(ApplicationStartedEvent event) {
        log.info("Application started BEGIN");
        inventFusion();
        log.info("Application started END");
    }

    @PostConstruct
    public void mypostConstruct() {
        log.info("My Post Construct BEGIN");
        inventFusion();
        log.info("My Post Construct END");
    }

    public void inventFusion() {
        log.info("We have made nuclear fusion cheaper than solar power");
    }
}
