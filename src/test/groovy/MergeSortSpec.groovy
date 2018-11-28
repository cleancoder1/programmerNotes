import sorting.MergeSort
import spock.lang.Specification

class MergeSortSpec extends Specification {


    def "merges left array to right array properly"() {
        given: ""
        MergeSort mergeSort = new MergeSort(aux: new Comparable[5])
        Comparable[] a = new Integer[5]
        a[0] = 1
        a[1] = 2
        a[2] = 8
        a[3] = 5
        a[4] = 9

        when:
        mergeSort.merge(a, 0, 2, 4)

        then:
        a[0] == 1
        a[1] == 2
        a[2] == 5
        a[3] == 8
        a[4] == 9
        true == mergeSort.isSorted(a)

    }

    def "fix merges left array to right array properly"() {
        given: ""
        MergeSort mergeSort = new MergeSort(aux: new Comparable[5])
        Comparable[] a = new Integer[3]
        a[0] = 2
        a[1] = 118
        a[2] = 21

        when:
        mergeSort.merge(a, 0, 1, 2)

        then:
        a[0] == 2
        a[1] == 21
        a[2] == 118
    }

    def " check if sorting worked"() {
        given: ""
        MergeSort mergeSort = new MergeSort()

        Comparable[] a = new Integer[6]
        a[0] = 2
        a[1] = 118
        a[2] = 21
        a[3] = 5
        a[4] = 9
        a[5] = 31
        when: ""

        mergeSort.sort(a)
        then: ""
        mergeSort.show(a)
        true == mergeSort.isSorted(a)
    }
}
