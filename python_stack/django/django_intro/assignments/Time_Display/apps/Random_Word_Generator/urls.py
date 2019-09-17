# Random_Word_Generator

from django.urls import path 
from . import views

urlpatterns = [
    path('',views.index),
    path('genPage',views.newGenerate)
]
