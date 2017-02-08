package com.jgosh.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gkamut on 2017-02-08.
 */
@Entity
public class Address {

    private Long id;
    private AddressType type;
    private String address1;
    private String address2;
    private String city;
    private String postCode;

    private Client client;

    public enum AddressType {
        REGISTERED,
        CORRESPONDENCE,
        REGULAR
    }

    protected Address() {
    }

    public Address(Client client, AddressType type, String address1, String address2, String city, String postCode) {
        this.client = client;

        this.type = type;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postCode = postCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
