
package com.airhacks;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class MessagesStore {

    @PersistenceContext
    EntityManager em;

    public Message find(long id) {
        Message retVal = this.em.find(Message.class, id);
        retVal.setPayload("read from DB");
        return retVal;
    }

    public long saveOrUpdate(Message message) {
        Message merged = em.merge(message);
        return merged.getId();
    }//commit


}
