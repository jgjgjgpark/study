package myproject.generic

import spock.lang.Specification

class Chapter2Test extends Specification {
    void setup() {
    }

    void cleanup() {
    }

    def "collection reverse"(){
        given:
        def collection = Arrays.asList(1,2,3);
        when:
        Collections.reverse(collection)
        then:
        assert collection[0] == 3
    }
}
