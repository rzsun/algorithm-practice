class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        k = len(nums1) - 1

        while i >= 0 and j >= 0:
            tail1 = nums1[i]
            tail2 = nums2[j]

            if tail1 > tail2:
                nums1[k] = tail1
                i -= 1
            else:
                nums1[k] = tail2
                j -= 1
            k -= 1

        while j >= 0:
            nums1[k] = nums2[j]
            j -= 1
            k -= 1
