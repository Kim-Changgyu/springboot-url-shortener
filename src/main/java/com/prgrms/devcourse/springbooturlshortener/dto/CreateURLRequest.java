package com.prgrms.devcourse.springbooturlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateURLRequest {
    private final String url;
}