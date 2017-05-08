package fr.xebia.xke.interfacetests.impl;

import fr.xebia.xke.interfacetests.FactoryComparableTest;
import fr.xebia.xke.interfacetests.FactoryEqualsTest;

class StringFactory implements FactoryComparableTest<String>, FactoryEqualsTest<String> {

    @Override
    public String createValue() {
        return "foo";
    }

    @Override
    public String createSmallerValue() {
        return "bar"; // 'b' < 'f' in "foo"
    }

    @Override
    public String createNotEqualValue() {
        return "baz";
    }

}
