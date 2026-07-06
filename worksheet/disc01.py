def evens(list_of_ints):
    return_list = []
    for i in list_of_ints:
        if i % 2 == 0:
            return_list.append(i)
    return return_list

list = [1,2,3]
list_even = evens(list)
print(list_even)

def count_words(list_of_words):
    counts = {}
    for i in list_of_words:
        if i in counts:
            counts[i] += 1
        else:
            counts[i] = 1
    return counts

list_map=[1,2,3,4,5,6,3,2,1]
map = count_words(list_map)
print(map)

class Dog():
    def __init__(self, name, size):
        self.name = name
        self.size = size
    def grow(self):
        self.size =+ 1
    def __str__(self):
        return self.name + " the size " + str(self.size) + " dog"
    
dogs = [Dog("maya", 1000), Dog("yipster", 5), Dog("scott", 25)]
print(dogs[0])
    
        
