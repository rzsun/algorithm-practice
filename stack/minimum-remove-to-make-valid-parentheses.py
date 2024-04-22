class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        """
        :type s: str
        :rtype: str
        """
        res = 0
        opens = 0
        remove = set()

        for i in range(0, len(s)):
            c = s[i]
            if c == '(':
                opens += 1
            if c == ')':
                if opens == 0:
                    remove.add(i)
                else:
                    opens -= 1
        
        for i in range(len(s)-1, -1, -1):
            if opens == 0:
                break
            c = s[i]
            if c == '(':
                remove.add(i)
                opens -= 1
        
        res = ""
        for i in range(0, len(s)):
            if i not in remove:
                res += s[i]

        return res
