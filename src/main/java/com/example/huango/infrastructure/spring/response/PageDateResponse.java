package com.example.huango.infrastructure.spring.response;

import lombok.Data;

import java.util.List;

@Data

public class PageDateResponse<T> {

    public int total;
    public List<T>  data;
}
