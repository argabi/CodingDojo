from flask import Flask, render_template, request, redirect
from time import strftime

app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    
    PY_strawberry = request.form['strawberry']
    PY_raspberry = request.form['raspberry']
    PY_apple = request.form['apple']

    PY_first_name = request.form['first_name']
    PY_last_name = request.form['last_name']
    PY_student_id = request.form['student_id']

    PY_DateTime =strftime("%m/%d/%Y %H:%M")

    PY_totalQuantity=int(PY_strawberry)+int(PY_raspberry)+int(PY_apple)

    print(f"Charging {PY_first_name} {PY_last_name} for {PY_totalQuantity} fruits") # whene u refresh page will charging again  :(((

    return render_template("checkout.html",
    Quantity_strawberry=PY_strawberry,Quantity_raspberry=PY_raspberry,Quantity_apple=PY_apple,
    Show_first_name=PY_first_name,Show_last_name=PY_last_name,Show_student_id=PY_student_id,
    show_DateTime=PY_DateTime,show_totalQuantity=PY_totalQuantity)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    



   