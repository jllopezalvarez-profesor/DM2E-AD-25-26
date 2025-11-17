package es.jllopezalvarez.ad.ut02conectores.ejemplos.ncapas.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public final class Customer {
    private final int customerId;
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address;
    private final String city;
    private final String country;
    private final String state;
    private final String postalCode;
    private final String phone;
    private final String fax;
    private final String email;
}
