#Countdown 
def Countdown(num):
    list1= []
    while num >=0:
        list1.append(num)
        num = num-1
    return list1
print(Countdown(5))

#Print and Return
def print_and_return(list2):
    print(list2[0])
    return list2[1]
x= print_and_return([1,2])
print(x)

#First Plus Length
def first_plus_length(list3):
    return list3[0] + len(list3)
xx=first_plus_length([1,2,3,4,5])
print(xx)

#Values Greater than Second
def values_greater_than_second(list4):
    if len(list4) < 2:
        return False
    newList =[]
    i =0
    while i +1 <len(list4):
        if list4[i]>list4[i+1]:
            newList.append(list4[i])
        i = i+1
    


    print (len(newList))
    return newList
xxx=values_greater_than_second([5,2,3,2,1,4])
print(xxx)

#This Length, That Value
def length_and_value(sizee , valuee):
    list5 =[]
    for x in range(sizee):
        list5.append( valuee)
    return list5
ali = length_and_value(6,2)
print(ali)