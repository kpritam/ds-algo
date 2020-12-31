package ds.linkedlist

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import ds.tree.BinaryTree

class BinaryTreeTest extends AnyWordSpec with Matchers:

  "size" must {
    "return total number of elements in the tree" in {
      BinaryTree.create(List(1, 2, 3, 4, 5)).size shouldBe 5
    }
  }

