class WordDictionary:
    def __init__(self):
        self.words = []

    def addWord(self, word: str) -> None:
        self.words.append(word)

    def search(self, word: str) -> bool:
        if '.' not in word:
            return word in self.words
        for w in self.words:
            if len(w)!=len(word):
                continue
            for i in range(len(word)):
                if word[i]=='.':
                    continue
                if word[i]!=w[i]:
                    break
            else:
                return True         
        return False

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)