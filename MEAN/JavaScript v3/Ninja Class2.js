//Assignment: Ninja Class 2 using ES5

function Ninja(name) {

    this.name = name;
    this.health = 100;

    //private varaibles
    var speed = 3
    var strenght = 3
    //////////////////////////////////////////////////////////////////////////////
    /// by me extra
    // 'Getter' functions help us read private variables
    function updateStrenght(num) {
        strenght += num
    }
    // 'Setter' functions help us update private variables
    this.drive = function (num) {
        updateStrenght(num);
        // return this will allow us to chain methods
        return this;
    }
    //////////////////////////////////////////////////////////////////////////////


    //methods
    this.sayName = function () { console.log("My ninja name is " + this.name + "!"); };

    this.showStats = function () {
        console.log("Name: " + this.name + ", Health: " + this.health +
            ", Speed: " + speed + ", Strength: " + speed);
    };

    // This should add +10 Health to the Ninja
    this.drinkSake = function () { this.health += 10 };
    /////////////////////////////////////////////////////////////////////////////////////////////
    this.punch = function (otherNinija) {
        otherNinija.health -= 5
        console.log(otherNinija.name + " was punched by " + this.name + " and lost 5 Health!")
    };

    this.kick = function (otherNinija) {
        otherNinija.health -= 15
        this.health -= 15
        //updateStrenght(1);
        console.log(this.drive()) // extra by me
        console.log(otherNinija.name + " was kicked by " + this.name + " and lost 15 Health!")
        console.log("In this case, " + otherNinija.name + " lost 15 health because " + this.name + " has 1 point of strength")
    };

}


// for Testing
var blueNinja = new Ninja("Goemon");
var redNinja = new Ninja("Bill Gates");

blueNinja.showStats();
redNinja.showStats();
console.log("____________________________________________________");

redNinja.punch(blueNinja);
blueNinja.showStats();
redNinja.showStats();
console.log("____________________________________________________");

blueNinja.kick(redNinja);
console.log("==")
blueNinja.showStats();
redNinja.showStats();