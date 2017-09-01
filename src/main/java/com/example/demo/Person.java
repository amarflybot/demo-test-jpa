package com.example.demo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amarendra on 01/09/17.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long pid;
    private String firstName;
    private String lastName;
    private Integer salary;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Person_Address", joinColumns = {
            @JoinColumn(name = "pid")
    }, inverseJoinColumns = {
            @JoinColumn(name = "aid")
    })
    private Set<Address> address;

    public Person() {
        this.address = new HashSet<>();
    }

    public Person(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new HashSet<>();
    }


    public Long getPid() {
        return pid;
    }

    public void setPid(final Long pid) {
        this.pid = pid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String name) {
        this.firstName = name;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(final Set<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
