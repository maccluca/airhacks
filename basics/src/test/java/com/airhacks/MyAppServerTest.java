/*
 */
package com.airhacks;

import java.lang.reflect.Field;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class MyAppServerTest {

    @Test
    public void deploy() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> fahrzeug = Class.forName("com.airhacks.Fahrzeug");
        Object fahrzeugInstance = fahrzeug.newInstance();
        Field[] fields = fahrzeug.getDeclaredFields();
        for (Field field : fields) {

            if (field.isAnnotationPresent(BitteInjizieren.class)) {
                field.setAccessible(true);
                BitteInjizieren annotation = field.getAnnotation(BitteInjizieren.class);
                System.out.println("injecting field = " + field + " async?:" + annotation.async());
                Class<?> type = field.getType();
                Object motorInstance = type.newInstance();
                field.set(fahrzeugInstance, motorInstance);
                System.out.println("--- " + fahrzeugInstance);
            } else {
                System.out.println("Not interested in: " + field);
            }
        }
    }

}
