
package com.airhacks.hello.boundary;

import java.util.Date;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
public class Initializer {

    @PostConstruct
    public void init() {
        System.out.println("--- reading configuration from air");
    }

    //@Schedule(second = "*/5", minute = "*", hour = "*")
    public void reinit() {
        System.out.println("Checking init flag " + new Date());
    }

    @Asynchronous
    public Future<String> asynchronous() {
        return new AsyncResult<>("42");
    }



}
