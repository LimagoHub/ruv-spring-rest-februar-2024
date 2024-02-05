package de.ruv.simple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(20)
public class OtherRunner implements CommandLineRunner {
    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Ich auch!");
    }
}
