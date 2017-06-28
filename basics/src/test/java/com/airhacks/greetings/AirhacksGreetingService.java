
package com.airhacks.greetings;

/**
 *
 * @author airhacks.com
 */
public class AirhacksGreetingService implements GreetingService {

    @Override
    public void greet(String msg) {
        System.out.println("Welcome to airhacks: " + msg);
        throw new IllegalStateException("too early");
    }

}
