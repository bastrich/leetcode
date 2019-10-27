package com.bastrich

class LRUCache(val capacity: Int) {

    val map = mutableMapOf<Int, Entry>()
    var first: Entry? = null
    var last: Entry? = null

    fun get(key: Int): Int {
        val entry = map[key]
        entry ?: return -1
        moveToLast(entry)
        return entry.value
    }

    fun put(key: Int, value: Int) {
        val entry = map[key]
        if (entry == null) {
            if (map.size < capacity) {
                val newEntry = Entry(key, value, last, null)
                map[key] = newEntry
                if (first == null) {
                    first = newEntry
                    last = newEntry
                } else {
                    last!!.next = newEntry
                    last = newEntry
                }
            } else {
                val deletedEntry = first!!
                first = first!!.next
                map.remove(deletedEntry.key)
            }
        } else {
            entry.value = value
            moveToLast(entry)
        }
    }

    private fun moveToLast(entry: Entry) {
        if (entry.prev == null && entry.next != null) {
            last!!.next = entry
            first = entry.next
            first!!.prev = null
            entry.prev = last
            entry.next = null
            last = entry
        } else if (entry.prev != null && entry.next != null){
            entry.prev!!.next = entry.next
            entry.next!!.prev = entry.prev
            entry.prev = last
            entry.next = null
            last!!.next = entry
            last = entry
        }
    }

    class Entry(var key: Int, var value: Int, var prev: Entry?, var next: Entry?)
}