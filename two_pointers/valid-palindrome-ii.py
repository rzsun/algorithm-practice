class Solution:
    def validPalindrome(self, s: str) -> bool:
        return self.traversePalindrome(s, 0, len(s)-1, 1)
    
    def traversePalindrome(self, s: str, start: int, end: int, deletes: int) -> bool:
        if start >= end:
            return True
        
        if s[start] == s[end]:
            return self.traversePalindrome(s, start+1, end-1, deletes)
        if s[start] != s[end]:
            if deletes > 0:
                return (self.traversePalindrome(s, start, end-1, deletes-1) or 
                self.traversePalindrome(s, start+1, end, deletes-1))
            else:
                return False
