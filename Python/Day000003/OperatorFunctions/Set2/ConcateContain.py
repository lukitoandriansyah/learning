import operator

txt1 = "Lukito"
txt2 = "Andriansyah"

print("Concatenated string is: ", end="")
print(operator.concat(txt1, txt2))

if operator.contains(txt1, txt2):
    print("Lukito contains Andriansyah")
else:
    print("Lukito not contains Andriansyah")
