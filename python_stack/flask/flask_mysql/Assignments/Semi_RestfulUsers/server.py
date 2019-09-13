# Semi-Restful Users | CRUD

from flask import Flask, render_template, request, redirect
# the file name of the SQL Connection :)
# import the function that will return an instance of a connection
from mysqlConnection import connectToMySQL
app = Flask(__name__)


@app.route("/")
def index():
    return redirect("/users")


@app.route("/users")  # home page
def index_users():
    mysql = connectToMySQL('friends_crud_db')
    allUsers = mysql.query_db('SELECT * FROM friends;')
    return render_template("index.html", allUsers=allUsers)


@app.route("/users/new")  # /users/new- GET - method
def new_users():
    return render_template("createUser.html")


@app.route("/users/<int:id_>/edit")  # Update User's Info
def user_Update(id_):
    mysql = connectToMySQL('friends_crud_db')

    data={'uID':id_}
    allUsers = mysql.query_db('SELECT * FROM friends WHERE id=%(uID)s;',data)
    
    return render_template("userEDIT.html", theUserInfo=allUsers[0])

#--------CRUD-------CRUD-------CRUD---------CRUD-----------CRUD------------CRUD--------CRUD----------CRUD--------CRUD--------CRUD--------CRUD------

#search by ID
@app.route("/users/<int:id_>")  # user Info by ID
def user_info(id_):
    mysql = connectToMySQL('friends_crud_db')

    data={'uID':id_}
    allUsers = mysql.query_db('SELECT * FROM friends WHERE id=%(uID)s;',data)
    
    return render_template("userInfo.html", theUserInfo=allUsers[0]) # [{ dfsdf:qeq,qweqweqw:,qweqwe}] [0] index 0 in the arry / list , just get the only dictionary {}
     
#======================
#INSERT
@app.route("/users/create", methods=["POST"]) # add Create
def add_Create():
    query = "INSERT INTO friends ( first_name, last_name ,email, created_at, updated_at) VALUES ( %(nFirstName)s, %(nLastName)s, %(nEmail)s, NOW(), NOW() );"
    data= {
        'nFirstName' : request.form['Form_FirstName'],
        'nLastName' : request.form['Form_LastName'],
        'nEmail' : request.form['Form_Email']
    }
    # connection
    mysql = connectToMySQL('friends_crud_db')
    # run the query
    theLastUserID_created= mysql.query_db(query,data)

    return redirect("/users/"+str(theLastUserID_created))

#======================
#Remove Delete
@app.route("/users/<int:id_>/destroy")  
def user_Delete(id_):
    mysql = connectToMySQL('friends_crud_db')
    data={'uID':id_}
    query = "DELETE FROM friends WHERE id = %(uID)s"
    mysql.query_db(query,data)
    
    return redirect("/users")

##======================
#update
@app.route("/users/<int:id_>/update", methods=["POST"])
def user_update(id_):

    query = "UPDATE friends set first_name=%(nFirstName_update)s, last_name=%(nLastName_update)s,email=%(nEmail_update)s, updated_at=NOW() WHERE id = %(uID)s;"
    data= {
        'uID':id_,
        'nFirstName_update' : request.form['Form_FirstName_update'],
        'nLastName_update' : request.form['Form_LastName_update'],
        'nEmail_update' : request.form['Form_Email_update']
    }
    # connection
    mysql = connectToMySQL('friends_crud_db')
    # run the query
    mysql.query_db(query,data)
    
    return redirect(f"/users/{id_}")







if __name__ == "__main__":
    app.run(debug = True)
