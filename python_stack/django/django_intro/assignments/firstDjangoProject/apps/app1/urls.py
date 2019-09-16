#URLs  for 
# app1

from django.urls import path
from . import views
urlpatterns = [
     path('',views.index), #index
     path('new',views.new),# new
     path('new/create',views.create), #create
     path('<int:num>',views.show), # show
     path('<int:num>/edit',views.edit), #edit
     path('<int:num>/delete',views.destroy) #delete
]
