x = ["Lukito", "Andriansyah"]
y = ["Lukito", "Andriansyah"]
z = x

# Returns False because z is the same object as x
print(x is not z)

# Returns True because x is not the same object as y,
# even if they have the same content
print(x is not y)

# To demonstrate the difference between "is not" and "!=":
# This comparison returns False because x is equal to y
print(x != y)
