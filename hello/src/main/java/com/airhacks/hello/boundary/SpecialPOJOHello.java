
package com.airhacks.hello.boundary;

import javax.enterprise.inject.Specializes;

/**
 *
 * @author airhacks.com
 */
@Specializes
public class SpecialPOJOHello extends POJOHello {

    @Override
    public String hey() {
        return "special " + super.hey();
    }


}
