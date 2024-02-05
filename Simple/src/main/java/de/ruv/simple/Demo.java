package de.ruv.simple;

import de.ruv.simple.translation.Person;
import de.ruv.simple.translation.Translator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Lazy
@RequiredArgsConstructor
public class Demo {

    //@Qualifier("lower")
    private final Translator translator; // 2.

    @Value("${Demo.message}")
    private final String message;

//    public Demo(final Translator translator, @Value("${Demo.message}") String message) { // 1.
//        this.translator = translator;
//        System.out.println(translator.translate(message));
//    }

    @PostConstruct
    public void run() { // 3.

        System.out.println(translator.translate(message));
    }

    @PreDestroy
    public void dispose() {
        System.out.println("wurde zerstört");
    }
}
