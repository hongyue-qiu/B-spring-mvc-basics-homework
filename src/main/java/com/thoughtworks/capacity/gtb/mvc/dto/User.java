package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotEmpty(message = "user name not empty")
    @Length(min = 3,max = 10,message = "user name length not between 3-10")
    @Pattern(regexp = "^[a-z0-9A-Z_]+",message = "user name only contain letter num _")
    String username;

    @NotEmpty(message = "password not empty")
    @Length(min = 5,max = 12,message = "password illegal")
    String password;

    @Email(message = "email address illegal")
    String email;

    public User(@NotEmpty @Length(min = 3, max = 10) @Pattern(regexp = "^[a-z0-9A-Z_]+") String username, @NotEmpty @Length(min = 5, max = 12) String password) {
        this.username = username;
        this.password = password;
    }
}
