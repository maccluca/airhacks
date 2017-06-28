
package com.airhacks.hello.boundary;

/**
 *
 * @author airhacks.com
 */
@Framework(Framework.Type.JAVAEE)
public class GoodPrefix implements Prefix {

    @Override
    public String get() {
        return "good ";
    }

}
