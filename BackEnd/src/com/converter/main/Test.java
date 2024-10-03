package com.converter.main;

import com.converter.api.ConsultaCodeApi;
import com.converter.modelo.SupportedCodeItemRecord;
import com.converter.modelo.SupportedCodeRecord;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ConsultaCodeApi consultaCodeApi = new ConsultaCodeApi();
        SupportedCodeRecord record =  consultaCodeApi.supportedCodeRecord();
    }
}
