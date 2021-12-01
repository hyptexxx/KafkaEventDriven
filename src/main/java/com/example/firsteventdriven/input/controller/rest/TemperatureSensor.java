package com.example.firsteventdriven.input.controller.rest;

import org.springframework.stereotype.Component;
import rx.Observable;

import java.util.Random;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Component
public class TemperatureSensor {
    private final Random rnd = new Random();
    private final Observable<String> dataStream =
            Observable
                    .range(0, Integer.MAX_VALUE)
                    .concatMap(tick -> Observable
                            .just(tick)
                            .delay(rnd.nextInt(5000), MILLISECONDS)
                            .map(tickValue -> this.probe()))
                    .publish()
                    .refCount();

    private String probe() {
        return "new Temperature(" + rnd.nextGaussian();
    }

    public Observable<String> temperatureStream() {
        return dataStream;
    }
}