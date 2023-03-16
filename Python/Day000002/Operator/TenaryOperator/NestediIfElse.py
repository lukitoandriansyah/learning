a, b = 38, 89

# FirstExample
print("Both a and b are equal" if a == b else "a is greater than b" if a > b else "a is smaller than b")

# Second example
if a != b:
    if a > b:
        print("a is greater than b")
    else:
        print("a is smaller than b")
else:
    print("Both a and b are equal")
