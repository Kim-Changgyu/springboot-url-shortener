package com.prgrms.devcourse.springbooturlshortener.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @Column(name = "request_count", nullable = false)
    private int requestCount;
}
