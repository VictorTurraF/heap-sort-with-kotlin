package org.example

data class Node(val index: Int, val value: Int)

class BinaryHeapTree {
    private var items: MutableList<Int> = mutableListOf();

    fun insert(item: Int) {
        if (this.items.isEmpty())
            this.items.add(item)
        else {
            val parent = this.getParent(items.size)

            if (item > parent.value) {
                this.items.add(parent.value)
                this.items[parent.index] = item
            } else {
                this.items.add(item)
            }
        }
    }

    private fun getParent(index: Int): Node {
        // Return an object with index and value
        val parentIndex = (index - 1)/2
        val parentValue = this.items[parentIndex]

        return Node(parentIndex, parentValue);
    }

    fun get(): List<Int> {
        return this.items
    }
}