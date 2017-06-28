
package com.airhacks.hello.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author airhacks.com
 */
@RequestScoped
@Named("hugo")
public class CityPresenter {

    @Size(min = 2, max = 3)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String cities() {
        return "sfo,duke city";
    }

    public Object ok() {
        System.out.println("Clicked !!!" + this.name);
        return null;
    }

}
