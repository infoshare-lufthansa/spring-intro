package pl.infoshare.springintro.support;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class IdGenerator {

    private final AtomicInteger idSequence = new AtomicInteger();

    public int getNext() {
        return idSequence.getAndIncrement();
    }
}
