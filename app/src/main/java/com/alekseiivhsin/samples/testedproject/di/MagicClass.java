package com.alekseiivhsin.samples.testedproject.di;

/**
 * Created on 20/11/2015.
 */
public class MagicClass implements IMagicClass {

    private static final String MAGIC_VALUE = "MAGIC_VALUE";

    @Override
    public String getMagicValue(){
        return MAGIC_VALUE;
    }
}
