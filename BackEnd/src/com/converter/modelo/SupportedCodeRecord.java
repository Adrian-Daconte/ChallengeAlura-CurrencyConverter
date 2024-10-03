package com.converter.modelo;

import java.util.List;

public record SupportedCodeRecord(
        String result,
        String documentation,
        String terms_of_use,
        List<List<String>>supported_codes
        ) {}
