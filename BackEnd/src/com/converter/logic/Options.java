package com.converter.logic;

import com.converter.modelo.MonedaInterface;

public class Options  {
    private String moneda1;
    private String moneda2;

    //constructor
    public Options(String moneda1, String moneda2) {
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;
    }

    //getters
    public String getMoneda1() {
        return moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }


}
