package org.spring;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Component
public class Person implements Executable {
    public int COUNT = 0;
    private static Person person = new Person();

    private String name;
    private int passport;
    //    private AddressBean address;
    private List<String> stringList;
    public static Person getInstance() {
        return person;
    }

//    @Autowired
//    @AddressQualifier
    private IAddress address;

    @Autowired
    public Person(@Qualifier("addressHome")IAddress address) {
        this.address = address;
    }

    public void init() {
        System.out.println("Init");
        name = "Maria";
    }

    public void destroy() {
        System.out.println("Destroy");
    }

    @Override
    public void perform() {
        System.out.println("Hello: " + name);
        System.out.println("Passport: " + passport);
        //      System.out.println("City: " + address.getCity());
        //      System.out.println("Country: " + address.getCountry());
        stringList.forEach(System.out::println);
//        System.out.println(address);
        address.print();
    }
}
