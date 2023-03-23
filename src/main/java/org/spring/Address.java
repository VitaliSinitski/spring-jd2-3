package org.spring;

import lombok.Data;

@Data
public class Address implements IAddress{
    private String street;
    private String house;

    @Override
    public void print() {
        System.out.println(street + " " + house);
    }
}
