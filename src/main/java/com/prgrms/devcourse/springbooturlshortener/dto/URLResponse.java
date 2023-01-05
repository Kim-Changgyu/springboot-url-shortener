package com.prgrms.devcourse.springbooturlshortener.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class URLResponse {
    private final String url;
    private final int requestCount;
}
