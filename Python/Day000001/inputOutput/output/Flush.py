import time

count_second = 3

#Countdown without flush

for count in reversed(range(count_second+1)):
    if count >0:
        print(count, end=">>>")
        time.sleep(1)
    else:
        print("Start")

#Countdown with flush

for count in reversed(range(count_second+1)):
    if count >0:
        print(count, end=">>>", flush=True)
        time.sleep(1)
    else:
        print("Start")