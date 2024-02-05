package de.ruv.simple.translation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Qualifier("upper")
//@Profile("production")
public class ToUpperTranslator implements Translator{
    @Override
    public String translate(final String message) {
        return message.toUpperCase();
    }
}
