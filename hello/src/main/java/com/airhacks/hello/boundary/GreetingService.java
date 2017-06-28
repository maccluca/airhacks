
package com.airhacks.hello.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(LoggingAspect.class)
public class GreetingService {

    @Inject
    POJOHello hello;

    @Inject
    @Framework(Framework.Type.CUSTOM)
    Prefix prefix;

    @Inject
    Event<String> events;

    @Inject
    @Any
    Instance<Prefix> all;

    public GreetingService() {
        System.out.println("######### Constructor: GreetingService " + this.getClass().getName());
    }


    @PostConstruct
    public void onInit() {
        System.out.println("Initializing: " + this + " " + hello.hey());
    }


    public String greet() {

        for (Prefix p : all) {
            System.out.println("- " + p.get());
            System.out.println("- " + p.getClass().getName());
        }

        String result = prefix.get() + " enterprise morning";
        events.fire(result);
        return result;
    }


}
