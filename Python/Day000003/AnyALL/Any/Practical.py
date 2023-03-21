list_a = []
list_b = []
for i in range(1, 11):
    list_a.append(4 * i)

for i in range(0, 10):
    list_b.append(list_a[i] % 5 == 0)

print('See whether at least one number is divisible by 5 in list_a =>')
print(any(list_b))
