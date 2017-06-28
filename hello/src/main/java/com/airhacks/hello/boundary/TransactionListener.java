
package com.airhacks.hello.boundary;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author airhacks.com
 */
public class TransactionListener {

    public void onSuccessfulGreet(@Observes(during = TransactionPhase.AFTER_SUCCESS) String msg) {
        System.out.println("++++++++cdiEvents " + msg);
    }

    public void onFailedGreet(@Observes(during = TransactionPhase.AFTER_FAILURE) String msg) {
        System.out.println("---------cdiEvents " + msg);
    }


}
