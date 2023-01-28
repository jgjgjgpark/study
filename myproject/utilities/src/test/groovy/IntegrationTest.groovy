import spock.lang.Specification

class IntegrationTest extends Specification {

    def "test1"(){
        given: "T "
//        def a = new T()

        when: "called test"
        def result = a.test()

        then: "string print"
        assert result == "test1"
    }

    def "regex test"() {
        when:
        def a = ~/\d{5}(-\d{4})?/
        println a
        then:
        print a.toString()
//        '12345' ==~ a
//        '12345-1234' ==~ a
//        '12345 12345-1234'.findAll(a)[0] == '12345'

    }

}
