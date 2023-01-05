package com.prgrms.devcourse.springbooturlshortener.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Base62Util {

    private static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static String encode(int value) {
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int i = value % 62;
            sb.append(BASE62[i]);
            value /= 62;
        }
        return sb.toString();
    }

    public static int decode(String value) {
        int result = 0;
        int power = 1;
        String S_BASE62 = new String(BASE62);
        for (int i = 0; i < value.length(); i++) {
            int digit = S_BASE62.indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }
}
