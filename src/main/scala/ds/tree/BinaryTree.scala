package ds.tree

enum BinaryTree[+V] :
    case Leaf extends BinaryTree[Nothing]
    case Branch[V](v: V, lb: BinaryTree[V], rb: BinaryTree[V]) extends BinaryTree[V]

    def size: Int =
        def go[V](b: BinaryTree[V]): Int =
            b match 
            case Leaf               => 0
            case Branch(_, l, r)    => 1 + go(l) + go(r)
        go(this)

    def height: Int =
        def go[V](b: BinaryTree[V]): Int =
            b match 
            case Leaf               => 0
            case Branch(_, l, r)    => 1 + Math.max(go(l), go(r))
        go(this)

    def preOrder: List[V] =
        def go[V](b: BinaryTree[V]): List[V] =
            b match 
            case Leaf               => Nil
            case Branch(v, l, r)    => v :: go(l) ++ go(r)
        go(this)
    
    def inOrder: List[V] =
        def go[V](b: BinaryTree[V]): List[V] =
            b match 
            case Leaf               => Nil
            case Branch(v, l, r)    => go(l)  ++ (v :: go(r))
        go(this)

object BinaryTree:
    def create[V](elms: List[V]): BinaryTree[V] = 
        elms match
        case Nil     => Leaf
        case x :: xs => 
            val mid = xs.length / 2
            Branch(x, create(xs.take(mid)), create(xs.drop(mid)))

@main def BinaryTreeExample() =
    val b = BinaryTree.create(List(1, 2, 3, 4, 5, 6, 7))
    println(b)
    println(b.size)
    println(b.height)
    println(b.preOrder)
    println(b.inOrder)
    