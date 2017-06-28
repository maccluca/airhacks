
package com.airhacks.greetings;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class DynamicProxyTest {

    @Test
    public void proxy() {

        GreetingService service = (GreetingService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{GreetingService.class}, getHandler());
        System.out.println(" " + service.getClass().getName());
        service.greet("good morning");
    }

    InvocationHandler getHandler() {
        return (proxy, method, args) -> {
            try {
                System.out.println(method + "tx.begin");
                Object result = method.invoke(new AirhacksGreetingService(), args);
                System.out.println(method + "tx.commit");
                return result;

            } catch (Exception ex) {
                System.out.println(method + "tx.rollback ");
                throw ex;
            }
        };
    }


}
