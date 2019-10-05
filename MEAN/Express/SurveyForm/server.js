//
const express = require("express");
const app = express();
const session = require('express-session');
//For FORM in HTML
const bodyParser = require('body-parser');  // for FORM in HTML  req.body.yourName
app.use(bodyParser.urlencoded({ extended: false }));  // for FORM in HTML    req.body
// for Session
app.use(session({
  secret: 'keyboardkitteh',
  resave: false,
  saveUninitialized: true,
  cookie: { maxAge: 60000 }
}))
//////////////////////////////////////////////
//port number
app.listen(8000, () => console.log("listening on port 8000"));
//static folder path
app.use(express.static(__dirname + "/static"));
//////////////////////////////////////////////
// ejs 
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
//////////////////////////////////////////////
//////////////////////////////////////////////
//////////////////////////////////////////////

////////////////// Routing ///////////////////

//index
app.get('/', (req, res) => {

  res.render("index")
});

//result 
app.post('/result', (req, res) => {
  contex = {
    'yourName': req.body.yourName,
    'fLanguage': req.body.fLAnguage,
    'Comment': req.body.comment
  }

  console.log(req.body);

  console.log("=======================================")
  res.render("results", contex)
});

