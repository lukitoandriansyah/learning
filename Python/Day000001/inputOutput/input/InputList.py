#input using list comprehension
x, y = [int(x) for x in input("Enter two values: ").split()]
print("First Number is: ", x)
print("Second number is: ", y)

x, y = [int(x) for x in input("Enter two values: ").split()]
print("First number is {} and Second number is {}".format(x, y))