package com.qin.isys.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 */
public class SimplePasswordEncoder implements PasswordEncoder {
    public String encode(CharSequence charSequence) {
        return null;
    }

    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
