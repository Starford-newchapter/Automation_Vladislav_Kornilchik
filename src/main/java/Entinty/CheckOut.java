package Entinty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderClassName = "CheckoutBuilder",setterPrefix = "with",buildMethodName = "create")
@AllArgsConstructor
@NoArgsConstructor

public class CheckOut {
    private String firstName;
    private String lastName;
    private String zipCode;


    public static class CheckoutBuilder {
        public CheckoutBuilder() {
        }
    }
}



