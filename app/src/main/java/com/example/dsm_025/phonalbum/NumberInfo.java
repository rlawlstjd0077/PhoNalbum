package com.example.dsm_025.phonalbum;

import java.io.Serializable;

/**
 * Created by dsm_025 on 2017-04-12.
 */

public class NumberInfo implements Serializable{
    private String name;
    private String number;
    private String email;

    public NumberInfo(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getName() + "##" + getNumber() + "##" + getEmail() + "##";
    }
}
