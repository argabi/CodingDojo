#Assignment: Counter

from flask import Flask, render_template, redirect  , session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' # set a secret key for security purposes


@app.route('/')
def index():

    # if the session  not exist then create it :)

    if  'CounterVisitor' in session:
        session ['CounterVisitor']+=1
    else :
        session ['CounterVisitor'] =1
    
    return render_template("index.html")


# clear the counter then redirect to the indext page ( root)
@app.route('/destroy_session')
def create_user():
   # session.clear()		# clears all keys
    session.pop('CounterVisitor')		# clears a specific key
    return redirect("/")	

if __name__ == "__main__":
    app.run(debug=True)
