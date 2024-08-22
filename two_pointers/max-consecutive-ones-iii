class Solution:

    def longestOnes(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0

        m = 0
        i = 0
        zeros = 0

        for j in range(len(nums)):
            if nums[j] == 0:
                zeros += 1
            
            while i <= j and zeros > k:
                if nums[i] == 0:
                    zeros -= 1
                i += 1

            m = max(m, j - i + 1)

        return m
