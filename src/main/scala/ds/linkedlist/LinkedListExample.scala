package ds.linkedlist

import ds.printLine

@main def LinkedListExamples: Unit = {
    val list = LinkedList(1, 2, 3, 4)
    printLine
    println(s"Original Linked List = $list")
    println(s"Length = ${list.length}")
    printLine

    list.add(5)
    list.add(6)
    println(s"[Add - 5,6] Linked List = $list")
    println(s"Length = ${list.length}")
    printLine

    println(s"[Find - 5] ${list.find(5)}")
    println(s"[Find - 7] ${list.find(7)}")
    printLine

    list.remove(4)
    println(s"[Remove] Linked List = $list")
    printLine

    val list2 = LinkedList(1)
    list2.remove(1)
    println(s"[Remove - 1 Item] Linked List = $list2")
    printLine
}
    