package com.bastrich

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class LRUCacheTest {

    @Test
    fun test() {
        val input = """
["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        """.trimIndent()

        val expectedOutput = "[null,null,null,1,null,-1,null,-1,3,4]"

        val operations = input.substring(input.indexOf(',') + 1, input.indexOf(']')).split(',')
            .map { it.substring(1, it.length - 1) }
        val numbers1 = input.substring(input.indexOf(']') + 4, input.length - 2).split("],[")
            .map {
                val nums = it.split(',')
                if (nums.size == 1) {
                    Pair(nums[0].toInt(), -1)
                } else {
                    Pair(nums[0].toInt(), nums[1].toInt())
                }
            }
        val lruCache = LRUCache(numbers1[0].first)
        val numbers = numbers1.drop(1)

        val expectedResult = expectedOutput.substring(1, expectedOutput.length - 1).split(',').drop(1)
            .map {
                if (it == "null") {
                    null
                } else {
                    it.toInt()
                }
            }

        val actualResult = operations.mapIndexed { i, _ ->
            if (operations[i] == "get") {
                lruCache.get(numbers[i].first)
            } else {
                lruCache.put(numbers[i].first, numbers[i].second)
                null
            }
        }

        assertEquals(expectedResult, actualResult)

        println("expected: $expectedResult")
        println("actual: $actualResult")

    }
}