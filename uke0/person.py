class Person:
    def __init__(self, alder, navn):
        self._alder = alder
        self._navn = navn
    
    def hent_alder(self):
        return self._alder
    
    def hent_navn(self):
        return self._navn