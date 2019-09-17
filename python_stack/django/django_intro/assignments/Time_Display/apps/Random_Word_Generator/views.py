# Random_Word_Generator

from django.shortcuts import render , redirect
from django.utils.crypto import get_random_string # for random String

get_random_string(length=14) # 14 characters
def index(request):
    request.session["ranString"] = get_random_string(length=14) # 14 characters # update with new
    request.session['counter_'] =1
    
       
    return render(request,'theIndex.html')

def newGenerate(request):
    
    if request.method == "POST":
        request.session['counter_'] +=1 # increment
        request.session["ranString"] =get_random_string(length=14) # 14 characters # update with new
        return render(request,'theIndex.html')