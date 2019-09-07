# Assignment: Great Number Game

import random# import the random module

from flask import Flask, render_template, redirect ,request , session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' # set a secret key for security purposes


@app.route('/')
def index():

    if not 'mySecruteNumber' in session : # if not  = first tiem load page
        session ['mySecruteNumber']= random.randint(1, 100) # random number between 1-100
        

    print("="*17)
    print(session['mySecruteNumber'])
    print("="*17)

    return render_template("index.html")


@app.route('/' , methods=['POST'])
def index_resulte():
    
    #wgene submit button clicked "G0"  >>>  parameters is  methods=['POST']
     
    try: # for avoeding error  integer number :)
        session ['theResulteFrom_TXTnumber'] = int(request.form['TXTnumber'])
    except ValueError:
        print('Please enter an integer')
    return redirect("/")


# clear the counter then redirect to the indext page ( root)
@app.route('/again')
def playAgain():
     session ['mySecruteNumber']= random.randint(1, 100)
     session['theResulteFrom_TXTnumber'] = -1 # inisilastion number -1 always wrong number
     return redirect("/")	


if __name__ == "__main__":
    app.run(debug=True)