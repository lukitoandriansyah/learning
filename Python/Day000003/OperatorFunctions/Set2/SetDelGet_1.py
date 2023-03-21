import operator

li = [1, 2, 4, 5, 6, 8]

print("The original list is : ", end="")
for i in range(0, len(li)):
    print(li[i], end=" ")

print("\r")

# Using setitem()
operator.setitem(li, 3, 4)

print("The modified list after setitem() is: ", end="")
for i in range(0, len(li)):
    print(li[i], end=" ")

print("\r")

# Using delitem()
operator.delitem(li, 2)

print("The modified list after delitem() is: ", end="")
for i in range(0, len(li)):
    print(li[i], end=" ")

print("\r")

# Using getitem()
print("The th element of list : ", end="")
print(operator.getitem(li, 3))
