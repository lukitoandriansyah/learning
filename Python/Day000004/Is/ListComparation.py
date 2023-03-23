list1 = []
list2 = []


def case1():
    if list1 == list2:
        print(True)
    else:
        print(False)


def case2():
    if list1 is list2:
        print(True)
    else:
        print(False)


case1()
case2()
