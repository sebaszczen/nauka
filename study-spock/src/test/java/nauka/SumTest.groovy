package nauka

import spock.lang.Specification
import spock.lang.Unroll

class SumTest extends Specification {

    def "set parameters by constructor"() {
        when:
        Sum sum = new Sum(2,5)
        then:
        sum.getX() == sum.getX()
        sum.getY() == sum.getY()
    }

    def "2 + 2 = 4"() {
        when:
        Sum sum = new Sum(2,2)
        then:
        sum.sum() == 4
    }

    @Unroll
    def "x + y give sum"() {
        when:
        Sum sum = new Sum(x, y)
        then:
        sum.sum() == x + y
        where:
        x   |   y
        2            |    3
        0            |    0
        -2           |    -5
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

}
