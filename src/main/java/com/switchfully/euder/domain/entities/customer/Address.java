package com.switchfully.euder.domain.entities.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;

    @JsonCreator
    public Address(@JsonProperty("streetName") String streetName, @JsonProperty("streetNumber") String streetNumber, @JsonProperty("postCode") String postCode, @JsonProperty("city") String city) {
        if (!isValidAddress(streetName, streetNumber, postCode, city))
            throw new IllegalArgumentException("Cannot create Address, one of the value is null");
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
