# Python Program to Update
# character of a String

String1 = "Hello, I'm a Lerner"
print("Initial String: ")
print(String1)

# Updating a character of the String
## As python strings are immutable, they don't support item updation directly
### there are following two ways
# 1
list1 = list(String1)
list1[2] = 'p'
String2 = ''.join(list1)
print("\nUpdating character at 2nd Index: ")
print(String2)

# 2
String3 = String1[0:2] + 'p' + String1[3:]
print(String3)

# Python Program to Update
# entire String

String1 = "Hello, I'm a Learner"
print("Initial String: ")
print(String1)

# Updating a String
String1 = "Welcome to the Geek World"
print("\nUpdated String: ")
print(String1)
