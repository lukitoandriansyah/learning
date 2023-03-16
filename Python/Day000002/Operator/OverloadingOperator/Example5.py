class A:
    def __init__(self, a):
        self.a = a

    # Overloading ~ operator, but with two operands
    def __invert__(self):
        return "This is the ~ operator, overloaded as binary operator."


ob1 = A(2)

print(~ob1)