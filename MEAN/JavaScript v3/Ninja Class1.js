//Assignment: Ninja Class 1   using ES5

function Ninja (name){

    this.name = name;
    this.health= 100;

    //private varaibles
    var speed =3
    var strenght =3

//methods
this.sayName = function(){ console.log("My ninja name is "+this.name+"!"); };

this.showStats = function(){ console.log("Name: "+this.name+", Health: "+this.health+
", Speed: "+speed+", Strength: "+speed); };

// This should add +10 Health to the Ninja
this.drinkSake = function() {this.health+=10};

}

var ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake()
ninja1.showStats();

