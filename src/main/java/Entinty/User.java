package Entinty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderClassName = "Builder", setterPrefix = "with", buildMethodName = "build")
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String login;
    private String password;

    public static class Builder {
        public Builder() {
        }
    }
}



