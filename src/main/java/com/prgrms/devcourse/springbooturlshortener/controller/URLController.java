package com.prgrms.devcourse.springbooturlshortener.controller;

import com.prgrms.devcourse.springbooturlshortener.dto.CreateURLRequest;
import com.prgrms.devcourse.springbooturlshortener.dto.URLResponse;
import com.prgrms.devcourse.springbooturlshortener.service.URLService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class URLController {

    private final URLService urlService;

    @GetMapping("/{id}")
    public void get(@PathVariable String id, HttpServletResponse response) throws IOException {
        response.sendRedirect(urlService.getURL(id));
    }

    @GetMapping("/{id}/info")
    public URLResponse get(@PathVariable String id) {
        return urlService.get(id);
    }

    @PostMapping("")
    public String save(@RequestParam("url") CreateURLRequest request) {
        return urlService.save(request);
    }
}
