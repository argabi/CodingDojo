from flask import Flask, render_template
app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template('index.html',numberOfBoxes=0) # number of boxes showe nothing  = 0

@app.route('/play')         
def play():
    return render_template('index.html',numberOfBoxes=3) # number of boxes to show  3 as defualt

@app.route('/play/<xTimes>')         
def playXTimes(xTimes):
    return render_template('index.html',numberOfBoxes=int(xTimes)) # number of boxes to show  xTimes as defualt

@app.route('/play/<xTimes>/<xColor>')         
def playXTimesColor(xTimes,xColor):
    return render_template('index.html',numberOfBoxes=int(xTimes) ,ColorName=xColor) # with colort name



if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
