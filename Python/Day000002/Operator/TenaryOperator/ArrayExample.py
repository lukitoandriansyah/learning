import random

border_array = int(input("Entry number of Border Array: "))
data = []
counter = 0
i = 0

while (counter < border_array):
    data.append(random.randrange(5))
    counter += 1

for i in range(len(data)):
    print(data[i])
    i += 1

for i in data:
    result = 'even' if i % 2 == 0 else 'odd'
    print(f'The number {i} is {result}')
