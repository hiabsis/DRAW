package com.example.huango.infrastructure.spring.response;

public class BoolResponse extends DateResponse<Boolean> {

    public static BoolResponse success = new BoolResponse(true);
    public static BoolResponse failure = new BoolResponse(false);

    public BoolResponse(Boolean data) {
        this.date = data;
    }
}
