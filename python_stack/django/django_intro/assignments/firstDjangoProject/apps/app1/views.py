from django.shortcuts import HttpResponse, redirect # add redirect to import statement
def index(request):
	return HttpResponse("placeholder to later display a list of all blogs") 

def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")

def create(request):
    return redirect("/")

def show(request,num):
    return HttpResponse(f"placeholder to display blog number: {num}")

def edit(request,num):
    return HttpResponse(f"placeholder to edit blog number: {num}")

def destroy(request,num):# must pass the virable here eveno if u do not use it 
    return redirect("/")