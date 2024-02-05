package de.ruv.simple;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(20)
@Component
public class MySpringRunner implements CommandLineRunner {


    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Hallo Welt");
    }
}
