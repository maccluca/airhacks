
package com.airhacks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author airhacks.com
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Message {

    @Id
    @GeneratedValue
    @XmlTransient
    private long id;

    @XmlElement(name = "hugo")
    private String payload;
    @XmlAttribute
    private int age;

    public Message(String payload, int age) {
        this.payload = payload;
        this.age = age;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


}
