# Python Program to Delete
# characters from a String

String1 = "Hello, I'm a Learner"
print("Initial String: ")
print(String1)

# Deleting a character
# of the String
String2 = String1[0:2] + String1[3:]
print("\nDeleting character at 2nd Index: ")
print(String2)


# Python Program to Delete
# entire String

String1 = "Hello, I'm a Learner"
print("Initial String: ")
print(String1)

# Deleting a String
# with the use of del
del String1
print("\nDeleting entire String: ")
print(String1)