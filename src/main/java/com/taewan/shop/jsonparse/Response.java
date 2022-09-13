package com.taewan.shop.jsonparse;

import lombok.Data;

@Data
public class Response {
    private String access_token;
    private String now;
    private String expired_at;
}
