import spock.lang.Specification

class SelectionSortSpec extends Specification {

    def "selection sorts "() {

        given: ""
        SelectionSort selectionSort = new SelectionSort()
        Integer[] a = new Integer[5]
        a[0] = 5
        a[1] = 2
        a[2] = 3
        a[3] = 4
        a[4] = 1

        when: ""

        selectionSort.sort(a)

        then: ""
        a[0] == 1
        a[1] == 2
        a[2] == 3
        a[3] == 4
        a[4] == 5
    }

}
