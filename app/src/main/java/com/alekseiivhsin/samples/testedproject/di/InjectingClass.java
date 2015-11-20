package com.alekseiivhsin.samples.testedproject.di;

/**
 * Created on 20/11/2015.
 */
public class InjectingClass  implements IInjectingClass{

    private static final String SECRET_VALUE = "SECRET_VALUE";

    @Override
    public String getValue(){
        return SECRET_VALUE;
    }
}
