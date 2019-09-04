# this is the server file
from flask import Flask

app=Flask(__name__)

@app.route('/')
def helloWorld():
    return "Hellow World"

@app.route('/dojo')
def dojo():
    return "Dojo!"

@app.route('/say/<theName>')
def sayName(theName):
    return "Hi " + theName

@app.route('/repeat/<timesNumber>/<theTXT>')
def repeating(timesNumber,theTXT):
    output=""
    for i in range(int(timesNumber)+1):
        output += theTXT +" "
    return output

if __name__ == "__main__":
     app.run(debug=True)    # Run the app in debug mode.