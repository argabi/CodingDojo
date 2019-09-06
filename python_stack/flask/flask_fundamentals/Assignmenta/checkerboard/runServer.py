from flask import Flask ,render_template
app = Flask(__name__)

@app.route('/')
def index(): #1 http://localhost:5000 - should display 8 by 8 checkerboard
    return render_template("index.html",needsRows=8,needsColums=8)

@app.route('/<int:colNum>')
def changeColNumbers(colNum): #2 http://localhost:5000/4 - should display 8 by 4 checkerboard
    return render_template("index.html",needsRows=8,needsColums=colNum)

@app.route('/<rowNum>/<colNum>')
def changeRowsColNumbers(rowNum,colNum): #3 http://localhost:5000/(x)/(y) - should display x by y checkerboard.  For example, http://localhost:5000/10/10 
    return render_template("index.html",needsRows=int(rowNum),needsColums=int(colNum))


if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
