# Assignment: Dojo Survey

from flask import Flask, render_template, request, redirect ,flash,session # added request
app = Flask(__name__)
app.secret_key="ali secret_key"
# our index route will handle rendering our form
@app.route('/')
def index():
    return render_template("index.html")


@app.route('/result', methods=['POST'])
def sendButton():    
    if len(request.form['yourName'])<1:
        flash("Please enter your name")
    if len(request.form['DojoLocation'])<1:
        flash("Please selecte Dojo's location")
    if len(request.form['FacoriteLanguage'])<1:
        flash("Please selecte your Favorite Language")

    rf_showName = request.form['yourName']
    rf_showDojoLocation = request.form['DojoLocation']
    rf_showFavoriteLanguage = request.form['FacoriteLanguage']
    rf_showComment = request.form['Comment']

    if  '_flashes' in session.keys():	# no flash messages means all validations passed
        return redirect("/")
    else:
        return render_template("resultPage.html", showName=rf_showName, showDojoLocation =rf_showDojoLocation ,showFavoriteLanguage=rf_showFavoriteLanguage, showComment=rf_showComment)
   

if __name__ == "__main__":
    app.run(debug=True)
