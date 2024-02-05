package de.ruv.simple.translation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("lower")
//@Profile("dev")
public class ToLowerTranslator implements Translator{
    @Override
    public String translate(final String message) {
        return message.toLowerCase();
    }
}
