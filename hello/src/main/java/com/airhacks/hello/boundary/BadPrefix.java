
package com.airhacks.hello.boundary;

import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Interceptors(LoggingAspect.class)
@Framework(Framework.Type.CUSTOM)
public class BadPrefix implements Prefix {

    @Override
    public String get() {
        return "bad ";
    }

}
