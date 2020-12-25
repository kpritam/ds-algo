package ds.linkedlist

class Node(val data: Int, var next: Node = null, var prev: Node = null):
    override def toString: String = s"[$data] -> ${next}"

class LinkedList(private var head: Node, private var last: Node):

    def add(item: Int): LinkedList = 
        val next = Node(item)
        last.next = next
        last = next
        this

    def find(item: Int): Option[Int] =
        def loop(h: Node, count: Int): Option[Int] =
            if (h.data == item) then Some(count)
            else if (h.next != null) then loop(h.next, count + 1)
            else None
        loop(head, 0)
    
    def remove(item: Int): Unit = 
        def loop(prev: Node, curr: Node): Unit =
            if (curr.data == item) then
                if (curr.next != null) then prev.next = curr.next else prev.next = null
            else if (curr.next != null) then loop(curr, curr.next)
            else ()
        if (head.data == item) then head = head.next
        else loop(head, head.next)

    def length: Int = fold(0)((acc, _) => acc + 1)

    def fold[T](z: T)(fn: (prev: T, curr: Node) => T) = 
        def loop(h: Node, result: T): T =
            if (h.next != null) then loop(h.next, fn(result, h.next))
            else result
        if (head == null) then z else loop(head, fn(z, head))
    
    def toList: List[Int] = fold[List[Int]](Nil) { (acc, curr) => curr.data :: acc }.reverse

    override def toString: String = if (head == null) then "null" else head.toString

object LinkedList:
    def apply(item: Int, items: Int*): LinkedList = 
        val head = Node(item)
        val last = items.map(Node(_)).fold[Node](head) { (x, y) => 
            x.next = y
            y
        }
        new LinkedList(head, last)