package com.remwaste.entity;

import com.remwaste.entity.strategy.*;
import lombok.Data;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Data
public class UserDetails {

    @PodamStrategyValue(FirstNameStrategy.class)
    private String firstName;

    @PodamStrategyValue(LastNameStrategy.class)
    private String lastName;

    @PodamStrategyValue(UsernameStrategy.class)
    private String username;

    @PodamStrategyValue(EmailStrategy.class)
    private String email;

    @PodamStrategyValue(PasswordStrategy.class)
    private String password;

    @PodamStrategyValue(MobileNumberStrategy.class)
    private String mobileNumber;
}
