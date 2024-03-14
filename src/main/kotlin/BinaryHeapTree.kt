package org.example

data class Item(val index: Int, var value: Int)

class BinaryHeapTree {
    private var items: MutableList<Int> = mutableListOf();

    fun insert(item: Int) {
        this.items.add(item)
        this.checkParentsAndSwapIfNecessary(this.getLastItem())
    }

    private fun checkParentsAndSwapIfNecessary(currentItem: Item) {
        if (currentItem.index == 0)
            return

        val parentItem = this.getParent(currentItem.index)

        if (currentItem.value > parentItem.value) {
            this.swap(currentItem, parentItem)
            this.checkParentsAndSwapIfNecessary(parentItem)
        }
    }

    private fun getLastItem(): Item {
        val lastIndex = this.items.size - 1
        val lastValue = this.items[lastIndex]

        return Item(lastIndex, lastValue)
    }

    private fun getParent(index: Int): Item {
        // Return an object with index and value
        val parentIndex = (index - 1)/2
        val parentValue = this.items[parentIndex]

        return Item(parentIndex, parentValue)
    }

    private fun swap(item: Item, parent: Item) {
        this.items[parent.index] = item.value
        this.items[item.index] = parent.value

        val aux = item.value
        item.value = parent.value
        parent.value = aux
    }

    fun get(): List<Int> {
        return this.items
    }
}