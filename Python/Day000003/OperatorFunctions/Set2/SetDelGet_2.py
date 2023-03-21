import operator

# Initializing list
li = [1, 5, 6, 7, 8]

# printing original list
print("The original list is : ", end="")
for i in range(0, len(li)):
    print(li[i], end=" ")

print("\r")

# using setitem() to assign 2,3,4 at 2nd,3rd and 4th index
operator.setitem(li, slice(1, 4), [2, 3, 4])

# printing modified list after setitem()
print("The modified list after setitem() is : ", end="")
for i in range(0, len(li)):
    print(li[i], end=" ")

print("\r")

# using delitem() to delete value at 3rd and 4th index
operator.delitem(li, slice(2, 4))

# printing modified list after delitem()
print("The modified list after delitem() is : ", end="")
for i in range(0, len(li)):
    print(li[i], end=" ")

print("\r")

# using getitem() to access 1st and 2nd element
print("The 1st and 2nd element of list is : ", end="")
print(operator.getitem(li, slice(0, 2)))
