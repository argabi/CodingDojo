//Assignment: Ninja Class 3 using ES6

class Ninja{
    constructor(name){
        this.name = name
        this.health= 100
        this.speed =3
        this.strength=3
    }

    //methods
     sayName (){
        console.log(`my Ninja name is ${this.name}`);
    }

    showStats (){
        console.log(`Name: ${this.name}, Strenght: ${this.strength}, Speed: ${this.speed}, Health: ${this.health}`);
    }

    drinkSake(){
         this.health +=10
    }

}

class Sensei extends Ninja {
    constructor(name ){
        super(name)

        this.health= 200
        this.speed =10
        this.strength=10
        this.wisdom= 10
    }

    speakWisdom(){
        super.drinkSake()
        console.log("What one programmer can do in one month, two programmers can do in two months.")
    }
}




// For Testing
const ninjaBule = new Ninja("ali");

ninjaBule.sayName()
ninjaBule.showStats()
ninjaBule.drinkSake()
ninjaBule.showStats()
console.log("----------------- testing class 2 ----------------- ")
const superSensei = new Sensei("Master Splinter");
superSensei.showStats()
superSensei.speakWisdom();
superSensei.showStats();