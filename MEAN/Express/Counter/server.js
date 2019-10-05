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

   req.session.Counter +=1
   console.log("counter is = ",req.session.Counter)
   contex ={
       'counterNumber':req.session.Counter
   }
   res.render("index",contex)
});


app.get('/CountByTwo', (req, res) => {

    req.session.Counter +=1 // here add one 
    res.redirect("/") // and here add other one 
     // total add 2
 });

app.get('/reset', (req, res) => {

    req.session.Counter =0
    console.log("counter is = ",req.session.Counter)
    res.redirect("/")
 });
