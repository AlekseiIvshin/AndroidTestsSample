package com.alekseiivhsin.samples.testedproject.di;

/**
 * Created on 20/11/2015.
 */
public class InjectingClass  implements IInjectingClass{

    private static final String MAGIC_VALUE = "MAGIC_VALUE";

    @Override
    public String getMagicValue(){
        return MAGIC_VALUE;
    }
}
