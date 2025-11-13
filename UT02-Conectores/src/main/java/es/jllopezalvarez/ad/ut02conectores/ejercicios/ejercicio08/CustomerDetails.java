package es.jllopezalvarez.ad.ut02conectores.ejercicios.ejercicio08;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public final class CustomerDetails {
    private final int customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String city;
    private final String country;
    private final String state;
    private final String postalCode;
    private final double totalInvoiceAmount;
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
