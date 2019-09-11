from flask import Flask, render_template,request,redirect
# the file name of the SQL Connection :)
# import the function that will return an instance of a connection
from mysqlConnection import connectToMySQL
app = Flask(__name__)


@app.route("/")
def index():
                             # DB name = 'first_flask'
    # call the function, passing in the name of our db
    mysql = connectToMySQL('first_flask')
                             # table Name = 'friends'
    # call the query_db function, pass in the query as a string
    friends = mysql.query_db('SELECT * FROM friends;')
    # print(friends)

    return render_template("index.html", all_friends=friends)


@app.route("/create_friend", methods=["POST"])
def add_friend_to_db():
    query = "INSERT INTO friends (first_name, last_name, occupation, created_at, update_at) VALUES ( %(fn)s, %(ln)s, %(oc)s, NOW(), NOW() );"
    data= {
        'fn' : request.form['fname'],
        'ln' : request.form['lname'],
        'oc' : request.form['occ']
    }
    #connection
    mysql = connectToMySQL('first_flask')
    #run the query
    mysql.query_db(query,data)
    return redirect("/")


if __name__ == "__main__":
    app.run(debug = True)
