#Using split() method
#Normal input

x, y = input("Enter two values: ").split()
print("Number of x: ", x)
print("Number of Y: ", y)
print("First number is {} and second number is {}".format(x, y))

#typecast input List() function
x = list(map(int, input("Enter multiple values: ").split()))
print("List of students: ", x)

