package com.taewan.shop.jsonparse;

import lombok.Data;

@Data
public class AccessToken {
    private String code;
    private String message;
    private Response response;


}
