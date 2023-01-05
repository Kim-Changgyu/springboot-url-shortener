package com.prgrms.devcourse.springbooturlshortener.repository;

import com.prgrms.devcourse.springbooturlshortener.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL, Long> {
}
