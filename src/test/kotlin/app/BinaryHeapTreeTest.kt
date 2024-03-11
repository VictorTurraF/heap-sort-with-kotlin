package app

import org.example.BinaryHeapTree
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class BinaryHeapTreeTest {
    @Test
    fun testTrueBeingTrue() {
        assertEquals(expected = true, actual = true);
    }

    @Test
    fun testInsertFirstItem() {
        val tree = BinaryHeapTree()

        tree.insert(4)
        tree.insert(2)
        val items = tree.get()

        assertEquals(expected = listOf(4, 2), items)
    }

    @Test
    fun testTreeItemSwap() {
        val tree = BinaryHeapTree()

        tree.insert(4)
        tree.insert(2)
        tree.insert(8)

        assertNotEquals(listOf(4, 2, 8), tree.get())
        assertEquals(listOf(8, 2, 4), tree.get())
    }
}