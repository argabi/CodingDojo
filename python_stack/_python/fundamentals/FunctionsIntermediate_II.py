x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]
#1_________________________________________________________________________________
x[1][0]=15
students[0]['last_name']='Bryant'
sports_directory['soccer'][0]='Andres'
z[0]["y"]=30
#2_________________________________________________________________________________
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
             ]

def iterateDictionary(some_list):
    for index in some_list:
        for theKey,theValue in index.items():
            print(theKey,"-", theValue+", ",end='') #end =  in same line
        print(end='\n') #new line

iterateDictionary(students)
#3_________________________________________________________________________________
print("-------------------------------------")
def iterateDictionary2(key_name, some_list):
    for index in some_list:
        print(index[key_name])
    
iterateDictionary2('first_name', students)
iterateDictionary2('last_name', students)
#4_________________________________________________________________________________
print("-------------------------------------")
dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(some_dict):
    for inx in some_dict:
        print(len(some_dict[inx]),"LOCATIONS")
        for i in some_dict[inx]:
            print(i)
        print()# new line
printInfo(dojo)