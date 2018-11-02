import spock.lang.Specification

class LinkedListStackSpec extends Specification {



    def "user should be able to create a generic stack and push elements to it"() {

        given:
        LinkedListStack<Integer> integerStack = new LinkedListStack<>()


        when:
        integerStack.push(Integer.valueOf(925))
        integerStack.push(Integer.valueOf(425))
        integerStack.push(Integer.valueOf(323))


        then:
        Integer.valueOf(323) == integerStack.pop()
        Integer.valueOf(425) == integerStack.pop()
        integerStack.pop()
        println integerStack.size()

    }

}
