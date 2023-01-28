package myproject

import spock.lang.Specification

class PersonTest extends Specification {
    def "object test"() {
        given: "person"
        def person = new Person(first: "jg", last: "park")
        when: "called"
        def string = person.toString()
        print string
        then:
        string != null
        person.first == "jg"
        person.getFirst() == "jg"
        person.getProperty("first") == "jg"
        person.class.name == "myproject.Person"
    }

    def "range test"() {
        when: "range"
        def intRange1 = 1..3
        def intRange2 = 1..<3
        then:
        intRange1.from == 1
        intRange1.to == 3
        intRange2.from == 1
        intRange2.to == 2
    }

    def "list test"() {
        when: "range"
        def nums = [1, 2, 3, 1, 1, 1]
        def minused = nums - 1
        def another = [1, 2, 3, 1, 1, 1]
        def integershifted = another << 2

        then:
        nums[0] == 1
        minused == [2, 3] // all 1 remove
        nums == [1, 2, 3, 1, 1, 1] // nums not changed
        integershifted == [1, 2, 3, 1, 1, 1, 2]
        another == [1, 2, 3, 1, 1, 1, 2]  // another is changed
    }

    def "map test"() {
        when:
        def map = ["class": "test", a: "helo"]
        then:
        map.class == "test"
        map.get("class") == "test"
        map.getClass().name == "java.util.LinkedHashMap"
        map["a"] == "helo"
    }

    def "automatic conversion of array to ArrayList"(){
        given: "string"
        def string = "I am a boy"
        when: "Split"
        List splitted = string.split()
        then:
        splitted == ["I", "am", "a", "boy"]
        splitted.class.name == "java.util.ArrayList"

    }

    def "closure test 1"(){
        when:
        List nums = [1,2]
        nums.each {println it}
        nums.eachWithIndex{ int entry, int i ->  println "$i: $entry" }
        then:
        println("ok")
    }

    def "closure test 2"(){
        when:
        Map nums = [a:1, b:2]
        nums.each {println "${it.key}, ${it.value}"}
        then:
        println("ok")
    }

    def "closure test 3"(){
        when: "last closure can be put after parenthesis"
        10.downto(7){
            println it
        }
        then:
        println("ok")
    }

    def "closure test 4 - map reduce"(){
        when: "last closure can be put after parenthesis"
        List nums = [1,2]
        nums.collect {it*2}
        .findAll {it %3 == 0}
        .sum()
        then:
        println("ok")
    }

}
