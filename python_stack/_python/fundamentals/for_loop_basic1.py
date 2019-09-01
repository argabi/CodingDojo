# Basic - Print all integers from 0 to 150
for num in range(151):
    print(num)

# Multiples of Five - Print all the multiples of 5 from 5 to 1,000
for valFive in range (1001):
    if(valFive %5 == 0):
        print(valFive)

# Counting, the Dojo Way - Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print "Coding Dojo".
for valFive in range (1,101):
    print(valFive)
    if(valFive %5 == 0):
        print("Coding")
    if(valFive %10 == 0):
        print("Coding Dojo")

# Whoa. That Sucker's Huge - Add odd integers from 0 to 500,000, and print the final sum.
sum = 0
for num in range(500000):
    if(num %2 != 0): # if odd number
        sum += num
print(sum)

# Countdown by Fours - Print positive numbers starting at 2018, counting down by fours.
for yesr in range(2018 ,0,-4):
    print(yesr)

# Flexible Counter
lowNum = 2
highNum = 9
mult = 3
for x in range(lowNum,  highNum+1):
    if(x % mult == 0):
        print(x)
