# Assignment: Dojo Survey

from flask import Flask, render_template, request, redirect  # added request
app = Flask(__name__)
# our index route will handle rendering our form
@app.route('/')
def index():
    return render_template("index.html")


@app.route('/result', methods=['POST'])
def sendButton():    

    rf_showName = request.form['yourName']

    rf_showDojoLocation = request.form['DojoLocation']
    rf_showFavoriteLanguage = request.form['FacoriteLanguage']
    rf_showComment = request.form['Comment']

    return render_template("resultPage.html", showName=rf_showName, showDojoLocation =rf_showDojoLocation ,showFavoriteLanguage=rf_showFavoriteLanguage, showComment=rf_showComment)


if __name__ == "__main__":
    app.run(debug=True)
