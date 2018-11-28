import sorting.QuickSort
import spock.lang.Specification

class QuickSortSpec extends Specification {

    def " check if sorting worked"() {
        given: ""
        QuickSort quickSort = new QuickSort()

        Comparable[] a = new Integer[6]
        a[0] = 2
        a[1] = 118
        a[2] = 21
        a[3] = 5
        a[4] = 9
        a[5] = 31
        when: ""

        quickSort.sort(a)
        then: ""
        quickSort.show(a)
        true == quickSort.isSorted(a)
    }
}
