package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amarendra on 01/09/17.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long aid;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "address")
    private Set<Person> personSet;

    public Address() {
        personSet = new HashSet<>();
    }

    public Address(final String name) {
        this.name = name;
        this.personSet = new HashSet<>();
    }


    public Long getAid() {
        return aid;
    }

    public void setAid(final Long aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(final Set<Person> personSet) {
        this.personSet = personSet;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", personSet=" + personSet +
                '}';
    }
}
