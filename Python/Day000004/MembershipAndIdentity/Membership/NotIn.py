list1 = [2, 3, 6, 4, 9]
listCountEven = []
listCountOdd = []


def countEvenOdd():
    for i in list1:
        if i % 2 == 0:
            listCountEven.append(i)
        if i % 2 != 0:
            listCountOdd.append(i)


def lengthList(lengthListEven, lengthListOdd):
    if len(lengthListEven) != 0:
        print("There's an even number in these list")
    if len(lengthListOdd) != 0:
        print("There's an odd number in these list")
    else:
        print("There's an odd or even number nn these list")


countEvenOdd()
lengthList(listCountEven, listCountOdd)
