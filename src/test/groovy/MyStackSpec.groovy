import spock.lang.Specification

class MyStackSpec extends Specification {
    def "user should be able to create a generic stack and push elements to it"() {

        given:
        MyStack<Integer> integerStack = new MyStack<>()


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

    def "adding iterator over a stack, does it pop elements "() {

        given:
        MyStack<Integer> integerStack = new MyStack<>()


        when:
        integerStack.push(Integer.valueOf(925))
        integerStack.push(Integer.valueOf(425))
        integerStack.push(Integer.valueOf(323))
        Iterator iterator = integerStack.iterator()


        then:
        while (iterator.hasNext()) {
            println iterator.next()
        }

    }
}
