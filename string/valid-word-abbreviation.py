class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        
        abbr_i = 0 # abbr idx
        word_i = 0 # word idx
        numStr = ""
        while abbr_i < len(abbr):
            if word_i >= len(word):
                return False
            if self.isLeadingNum(abbr[abbr_i]):
                glob, offset = self.getNumAndOffset(abbr, abbr_i)
                abbr_i += offset
                word_i += glob
            else:
                if word[word_i] != abbr[abbr_i]:
                    return False
                abbr_i += 1
                word_i += 1
        return word_i == len(word)    
    
    def getNumAndOffset(self, abbr: str, i: int) -> (int, int):
        globStr = ""
        offset = 0

        while i < len(abbr) and self.isNum(abbr[i]):
            globStr += abbr[i]
            offset += 1
            i += 1

        return int(globStr), offset

    def isLeadingNum(self, c: str) -> bool:
        return c in {'1', '2', '3', '4', '5', '6', '7', '8', '9'}

    def isNum(self, c: str) -> bool:
        return c in {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}
