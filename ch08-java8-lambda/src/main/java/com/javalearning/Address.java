package com.javalearning;

import java.util.Optional;

public class Address {

    private Country country;
    //get 方法要用Optional的
    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Address(Country country) {
        this.country = country;
    }
}