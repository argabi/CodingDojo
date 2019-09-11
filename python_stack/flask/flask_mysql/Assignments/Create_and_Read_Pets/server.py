#Assignment: Create and Read Pets

from flask import Flask, render_template,request,redirect
# the file name of the SQL Connection :)
# import the function that will return an instance of a connection
from mysqlConnection import connectToMySQL
app = Flask(__name__)


@app.route("/")
def index():
    mysql = connectToMySQL('first_flask')
                         
    allPets = mysql.query_db('SELECT * FROM pets;')

    return render_template("index.html", allPets=allPets)


@app.route("/addPet", methods=["POST"])
def add_Pet_to_db():
    query = "INSERT INTO pets ( name, type, created_at, updated_at) VALUES ( %(nName)s, %(nType)s, NOW(), NOW() );"
    data= {
        'nName' : request.form['theName'],
        'nType' : request.form['theType']
    }
    #connection
    mysql = connectToMySQL('first_flask')
    #run the query
    mysql.query_db(query,data)
    return redirect("/")


if __name__ == "__main__":
    app.run(debug = True)
