list_a = []
list_b = []

for i in range(1, 21):
    list_a.append(4 * 1 - 3)

for i in range(0, 20):
    list_b.append(list_a[i] % 2 == 1)

print('See whether all numbers in list_a are odd =>')
print(all(list_b))
