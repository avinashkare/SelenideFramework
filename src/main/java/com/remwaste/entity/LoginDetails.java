package com.remwaste.entity;

import lombok.Data;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
public class LoginDetails {

    @PodamStringValue(strValue = "john2007")
    private String userName;

    @PodamStringValue(strValue = "john2007")
    private String password;
}
