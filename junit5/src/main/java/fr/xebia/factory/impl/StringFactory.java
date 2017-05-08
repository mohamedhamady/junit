package fr.xebia.factory.impl;


import fr.xebia.factory.Factory;

public class StringFactory implements Factory<String> {

    @Override
    public String createValue() {
        return "foo";
    }
}
