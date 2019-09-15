#Assignment: Login and Registration
import re  # the regex module
from flask import Flask, render_template, request, redirect, session, flash
from mysqlConnection import connectToMySQL
app = Flask(__name__)
app.secret_key = '_5#y2L"F4Q8z\n\xec]/'
# __________________________________________________________________________________________________________________________________________________________________
# create a regular expression object that we'll use later
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
LETTERS_only_REGEX = re.compile(r'[a-zA-Z]+')


def isRegisterFormValied():
    # #Validations and Fields to Include
    is_valid = True

# 1 First Name - letters only, at least 2 characters and that it was submitted  $ done
    if len(request.form['FirstName_Register']) < 2 and not LETTERS_only_REGEX.match(request.form['FirstName_Register']):
        is_valid = False
        flash("Please enter a first name")

# 2 Last Name - letters only, at least 2 characters and that it was submitted $ done
    if len(request.form['LastName_Register']) < 2 and not LETTERS_only_REGEX.match(request.form['LastName_Register']):
        is_valid = False
        flash("Please enter a last name")

# 3 Email - valid Email format, does not already exist in the database, and that it was submitted   $ done
    mysql = connectToMySQL('flask_project')
    data = {'uEmail': request.form['Email_Register']}
    isUserEmail_inDB = mysql.query_db(
        'SELECT user_email FROM users WHERE user_email=%(uEmail)s;', data)
    print("-----Ali----", isUserEmail_inDB)

    # test whether a field matches the pattern
    if not EMAIL_REGEX.match(request.form['Email_Register']):
        is_valid = False
        flash("Invalid email address!")
    # check it in DB
    elif len(isUserEmail_inDB) > 0:
        is_valid = False
        flash("This Email already registred")


# 4 Password - at least 8 characters, and that it was submitted  $ done
    if len(request.form['Password_Register']) < 8:
        is_valid = False
        flash("Password should be at least 8 characters")

# 5 Password Confirmation - matches password  $ done
    if (request.form['Password_Register']) != (request.form['ConfirmPassword_Registern']):
        is_valid = False
        flash("Password is not same")

    return is_valid


# __________________________________________________________________________________________________________________________________________________________________
# Home page
@app.route("/")
def index():
    return render_template("register_login_page.html")

#logout
@app.route("/logout")
def userLogout():
    session.clear()	
    return redirect("/")

#login
@app.route("/success", methods=["POST","GET"])
def userLogin():
    if session["logedIn"] == True :
        return render_template("loged.html")
    else:
        return redirect("/")
    

# Regisration Button
@app.route("/register", methods=["POST"])
def registerNewUser():
    if isRegisterFormValied():
        mysql = connectToMySQL('flask_project')
        query = "INSERT INTO users ( user_first_name, user_last_name ,user_email,user_password ,user_salt,user_created_on) VALUES ( %(nFirstName_RegesterForm)s, %(nLastName_RegesterForm)s, %(nEmail_RegesterForm)s, %(nPassword_RegesterForm)s, %(nSaltUser)s, NOW() );"
        data = {
            'nFirstName_RegesterForm': request.form['FirstName_Register'],
            'nLastName_RegesterForm': request.form['LastName_Register'],
            'nEmail_RegesterForm': request.form['Email_Register'],
            'nPassword_RegesterForm': request.form['Password_Register'],
            'nSaltUser': 'Salt0012369Ali'
        }
        session['UserEmail_Registred'] = request.form['Email_Register']
        session['UserID_Registred'] = mysql.query_db(query, data)
        session["logedIn"] = True
    else:
        print("some Error")

    return redirect("/success")


if __name__ == "__main__":
    app.run(debug=True)
