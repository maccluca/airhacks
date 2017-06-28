
package com.airhacks.hello.boundary;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("greetings")
public class GreetingsResource {

    @Inject
    GreetingService service;

    @Inject
    Event<String> listener;

    @Resource
    SessionContext context;

    @GET
    public String all() {
        String retVal = service.greet();
        listener.fire("#### resource " + retVal);
        this.context.setRollbackOnly();
        return retVal;
    }


}
