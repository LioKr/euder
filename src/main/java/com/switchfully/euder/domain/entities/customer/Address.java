package com.switchfully.euder.domain.entities.customer;

public final class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;

    public Address(String streetName, String streetNumber, String postCode, String city) {
        if(!isValidAddress(streetName,streetNumber,postCode,city)) throw new IllegalArgumentException("Cannot create address, one of the value is null");
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
    }

    private boolean isValidAddress(String streetName, String streetNumber, String postCode, String city) {
        return streetName != null
                && streetNumber != null
                && postCode != null
                && city !=null;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
