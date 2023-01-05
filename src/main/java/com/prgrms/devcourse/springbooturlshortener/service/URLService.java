package com.prgrms.devcourse.springbooturlshortener.service;

import com.prgrms.devcourse.springbooturlshortener.dto.CreateURLRequest;
import com.prgrms.devcourse.springbooturlshortener.dto.URLResponse;
import com.prgrms.devcourse.springbooturlshortener.entity.URL;
import com.prgrms.devcourse.springbooturlshortener.repository.URLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class URLService {

    private final URLRepository urlRepository;

    @Transactional
    public String save(CreateURLRequest request) {
        URL url = new URL();
        url.setUrl(request.getUrl());

        URL entity = urlRepository.save(url);

        return Base62Util.encode((int) entity.getId());
    }

    @Transactional
    public String getURL(String value) {
        URL url = urlRepository.findById((long) Base62Util.decode(value))
                .orElseThrow();

        url.setRequestCount(url.getRequestCount() + 1);
        URL entity = urlRepository.save(url);

        return entity.getUrl();
    }

    @Transactional(readOnly = true)
    public URLResponse get(String value) {
        URL entity = urlRepository.findById((long) Base62Util.decode(value))
                .orElseThrow();

        return URLResponse.builder()
                .url(entity.getUrl())
                .requestCount(entity.getRequestCount())
                .build();
    }
}
