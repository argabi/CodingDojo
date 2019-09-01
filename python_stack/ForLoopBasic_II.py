#Biggie Size
def biggie_size(list1):
    for i in list1:
        if i >0:
            list1[list1.index(i)] = "big"
    return list1
arrVAlue= biggie_size([-1, 3, 5, -5])
print(arrVAlue)

print("=============================")
#Count Positives
def count_positives(list1):
    sum = 0
    for i in list1:
        if i >0:
            sum = sum+1
    list1[len(list1)-1]=sum
    return list1
arrVAlue=count_positives([1,6,-4,-2,-7,-2]) 
print(arrVAlue)

print("=============================")
#CSum Total
def sum_total(list1):
    sum = 0
    for i in list1:
        sum +=i
    return sum
arrVAlue=sum_total([6,3,-2])
print(arrVAlue)

print("=============================")
#Average 
def average(list1):
    sum = 0
    for i in list1:
        sum +=i
    return sum/len(list1)
arrVAlue=average([1,2,3,4])
print(arrVAlue)

print("=============================")
#Length 
def Length(list1):
    return len(list1)
arrVAlue=Length([1,2,3,4])
print(arrVAlue)

print("=============================")
#Minimum 
def minimum(list1):
    if len(list1)<=0:
        return False
    min =list1[0]
    for x in list1:
        if x < min :
            min = x
    return min
arrVAlue=minimum([37,2,1,-9])
print(arrVAlue)

print("=============================")
#Maximum  
def maximum(list1):
    if len(list1)<=0:
        return False
    max =list1[0]
    for x in list1:
        if x > max :
            max = x
    return max
arrVAlue=maximum([37,2,1,-9])
print(arrVAlue)

print("=============================")
#Ultimate Analysis
def ultimate_analysis(list1):
    if len(list1)<=0:
        return False
    sum =0
    max =list1[0]
    min = list1[0]
    my_dict = {}

    for x in list1:
        sum +=x
        if x > max :
            max = x
        if x < min :
            min = x

    my_dict['sumTotal'] = sum
    my_dict['average'] = sum /len(list1)
    my_dict['minimum'] = min
    my_dict['maximum'] = max
    my_dict['length'] = len(list1)
    return my_dict

arrVAlue=ultimate_analysis([37,2,1,-9])
print(arrVAlue)

print("=============================")
#Reverse List
def reverse_list(list1):
    for i in range(0,int(len(list1)/2),1):
        temp =list1[i]
        list1[i] = list1[len(list1)-1-i]
        list1[len(list1)-1-i]=temp
    return list1

arrVAlue=reverse_list([37,2,1,-9]) 
print(arrVAlue)