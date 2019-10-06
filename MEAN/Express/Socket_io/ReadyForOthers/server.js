//
const express = require("express");
const app = express();
const session = require('express-session');
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

