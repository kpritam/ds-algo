package ds.linkedlist

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class LinkedListTest extends AnyWordSpec with Matchers:

  "apply" must {
    "create new LinkedList" in {
      LinkedList(1, 2, 3).toList shouldBe List(1, 2, 3)
    }
  }

  "length" must {
    "return total number of elements in the LinkedList" in {
      LinkedList(1, 2, 3).length shouldBe 3
    }
  }

  "find" must {
    "return index of found element" in {
      LinkedList(1, 2, 3).find(2) shouldBe Some(1)
    }

    "return None when element not found" in {
      LinkedList(1, 2).find(3) shouldBe None
    }
  }

  "remove" must {
    "delete element from linked list" in {
      val l = LinkedList(1, 2, 3)
      l.remove(2)
      l.toList shouldBe List(1, 3)
    }

    "perform no-op when element not found" in {
      val l = LinkedList(1, 2, 3)
      l.remove(4)
      l.toList shouldBe List(1, 2, 3)
    }
  }
