package com.bastrich

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.isEmpty()) {
            return findMedian(nums2)
        }
        if (nums2.isEmpty()) {
            return findMedian(nums1)
        }
        if (nums1.last() <= nums2.first()) {
            return findMedian(nums1, nums2)
        }
        if (nums2.last() <= nums1.first()) {
            return findMedian(nums2, nums1)
        }
    }

    fun findMedian(nums1: IntArray, nums2: IntArray): Double {
        if ((nums1.size + nums2.size) % 2 == 1) {
            return nums[(nums1.size + nums2.size)/2].toDouble()
        } else {
            return (nums[nums.size/2 - 1].toDouble() + nums[nums.size/2].toDouble()) / 2
        }
    }

    fun findMedian(nums: IntArray): Double {
        if (nums.size % 2 == 1) {
            return nums[nums.size/2].toDouble()
        } else {
            return (nums[nums.size/2 - 1].toDouble() + nums[nums.size/2].toDouble()) / 2
        }
    }

    fun findMedian(nums: IntArray): Double {
        if (nums.size % 2 == 1) {
            return nums[nums.size/2].toDouble()
        } else {
            return (nums[nums.size/2 - 1].toDouble() + nums[nums.size/2].toDouble()) / 2
        }
    }


}