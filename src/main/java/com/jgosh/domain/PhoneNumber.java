package com.jgosh.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by gkamut on 2017-02-08.
 */
@Entity
public class PhoneNumber {
    private Long id;
    private String number;
    private PhoneNumberType type;

    private Client client;

    public enum PhoneNumberType {
        MOBILE,
        LANDLINE,
        WORK
    }

    protected PhoneNumber() {
    }

    public PhoneNumber(Client client, PhoneNumberType type, String number) {
        this.client = client;
        this.type = type;
        this.number = number;
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
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public PhoneNumberType getType() {
        return type;
    }

    public void setType(PhoneNumberType type) {
        this.type = type;
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
