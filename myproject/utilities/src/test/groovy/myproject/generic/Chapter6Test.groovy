package myproject.generic

import myproject.utilities.StringUtils
import spock.lang.Specification

class Chapter6Test extends Specification{
    def "List<Object> -> List<String>"(){
        given: "list of objects"
        def objects = Arrays.<Object>asList(1, "b")
        when: "called"
        def strings = StringUtils.convert(objects)
        then:
        thrown(ClassCastException)
    }
}
