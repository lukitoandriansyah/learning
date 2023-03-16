a, b = 3, 8

# TupleExample
print((b, a)[a > b])

# DictExample
print({True: a, False: b}[a > b])

# LambdaExample
print((lambda: b, lambda: a)[a > b]())
