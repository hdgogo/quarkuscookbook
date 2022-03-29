package org.example.ch5.progmodel;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Locale;

@ApplicationScoped
public class LocaleProducer {

    @Produces
    public Locale getDefaultLocale(){
        return Locale.getDefault();
    }

    @Produces
    @Named("en_US")
    public Locale getEnUSLocale(){
        return Locale.US;
    }

    @Produces
    @Named("es_ES")
    public Locale getEsESLocale(){
        return new Locale("es","ES");
    }

    @Produces
    @SpainLocale
    public Locale getSpainLocale(){
        return new Locale("es", "ES");
    }

    /*@Produces
    @Quote
    Message getQuote(InjectionPoint msg){
        Quote q = msg.getAnnotated().getAnnotation(Quote.class);
        return new Message(q.msg() , q.source());
    }*/
}
