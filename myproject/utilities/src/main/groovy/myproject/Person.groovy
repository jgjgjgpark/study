package myproject

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

//@ToString(includeNames=true) @EqualsAndHashCode
//@TupleConstructor
@Canonical
class Person {
    String first
    String last
}
