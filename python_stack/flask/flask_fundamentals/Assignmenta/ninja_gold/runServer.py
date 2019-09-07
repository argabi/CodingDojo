# strtingA = ""

# strtingA = "{0} {1}".format("Tea", strtingA)

# print(strtingA)

# ________________________________________________________________________________

# Assignment: Ninja Gold

import random  # import the random module
from time import strftime
from flask import Flask, render_template, redirect, request, session
app = Flask(__name__)
# set a secret key for security purposes
app.secret_key = 'keep it secret, keep it safe'

# ------------------------------------------------------------
@app.route('/')
def index():

    if not 'points' in session:
        session['points'] = 0
        session['ActivitesList'] = ""

    return render_template("index.html")


@app.route('/process_money', methods=['POST'])
def Result():
    RandPointGet = 0
    placeName=""

    if request.form['building'] == "farm":
        RandPointGet = random.randint(10, 20)
        placeName="farm"

    elif request.form['building'] == "cave":
        RandPointGet = random.randint(5, 10)
        placeName="cave"

    elif request.form['building'] == "house":
        RandPointGet = random.randint(2, 5)
        placeName="house"

    elif request.form['building'] == "casino":
        RandPointGet = random.randint(-50, 50)
        placeName="casino"


    session['points'] += RandPointGet

    
    

    #if the number positive  = green | if not then  red
    if RandPointGet >0 :
        greenTxt =f"Eraned {RandPointGet} golds from the {placeName}! (" + strftime("%m/%d/%Y %H:%M") +")" # make formating
        greenTxt = f"<div class='text-success'>{greenTxt}</div>" # add color

        session['ActivitesList'] = "{0} {1}".format(greenTxt, session['ActivitesList']) # add in first
    else:
        redTXT = f"Entered a casino and lost {RandPointGet} golds... Ouch.. (" + strftime("%m/%d/%Y %H:%M") +")" # make formating
        redTXT = f"<div class='text-danger'>{redTXT}</div>" # add color

        session['ActivitesList'] = "{0} {1}".format(redTXT, session['ActivitesList']) # add in first
 
    return redirect('/')


@app.route('/again')
def again():
    session['points'] = 0
    session['ActivitesList'] = ""
    return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)
