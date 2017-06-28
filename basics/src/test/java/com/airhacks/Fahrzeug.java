
package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class Fahrzeug {

    @BitteInjizieren("race")
    private Motor motor;

    String name;

    @Override
    public String toString() {
        return "Fahrzeug{" + "motor=" + motor + ", name=" + name + '}';
    }

}
