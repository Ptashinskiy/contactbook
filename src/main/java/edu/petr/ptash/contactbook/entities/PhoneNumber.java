
package edu.petr.ptash.contactbook.entities;

import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String operatorName;

    @Column(nullable = false, unique = true)
    private String number;

    public PhoneNumber(String operatorName, String number) {
        this.operatorName = operatorName;
        this.number = number;
    }

    public PhoneNumber() {}

    public long getId() {
        return id;
    }


    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

