package org.spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@AddressQualifier
@Data
public class AddressHome implements IAddress{
    private String street;
    private String house;

    @Override
    public void print() {
        System.out.println(street + " " + house);
    }
}
