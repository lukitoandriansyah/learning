# Using end arguments
#Standard output
print("Hallo dunia!", end=" ")
print("Ini saya, Balsem")

#StandardList
a = [1, 2, 3, 4]
for value in range(len(a)):
    print(a[value], end=" ")

print()

#ListAdvanced
a = [1, 2, 3, 4]
print(*a)

# Using sys
import sys
#Standard output
sys.stdout.write("Hallo dunia ")
sys.stdout.write("Saya balsem")
