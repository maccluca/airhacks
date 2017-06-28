
package com.airhacks.hello.boundary;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class LoggingAspect {

    @AroundInvoke
    public Object egal(InvocationContext ic) throws Exception {
        Method method = ic.getMethod();
        long start = System.currentTimeMillis();
        try {

            System.out.println("method = " + method);
            return ic.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            System.out.println("Method: = " + method + " invoke in: " + duration);
        }
    }


}
