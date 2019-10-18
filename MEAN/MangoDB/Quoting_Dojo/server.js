// Express assignment Cars and Cats using EJS
const express = require("express");
const app = express();
const session = require('express-session');
const flash = require('express-flash');
const mongoose = require('mongoose');

app.use(session({
   secret: 'keyboardkitteh',
   resave: false,
   saveUninitialized: true,
   cookie: { maxAge: 60000 }
 }))

app.use(flash());
app.listen(8000, () => console.log("listening on port 8000"));
//static folder - static content must go in the static folder including styles and static javascript files
app.use(express.static(__dirname + "/static"));
//////////////////////////////////////////////////////////////
// Using Templates (EJS)  Embedded Javascript.
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
//////////////////////////////////////////////////////////////
//for post method and form body
app.use(express.urlencoded({ extended: true }));


// ----- DB -----

//Note: If you connect to a database that doesn't exist, Mongoose will create the DB for you!
mongoose.connect('mongodb://localhost/Quoting_Dojo_DB', { useNewUrlParser: true }); //Connect Mongoose to MongoDB

// Mongoose Schema --------------------------------------------------------------------------
const UserSchema = new mongoose.Schema({
   //validations
   name: { type: String, required: true, minlength: 6},
   quote: { type: String, required: true, minlength: 6}
})
// create an object to that contains methods for mongoose to interface with MongoDB
const User = mongoose.model('User', UserSchema);
//--------------------------------------------------------------------------


//Routing

// request, response 
app.get('/', (request, response) => {
   response.render('index')
});

/////////////
app.get('/quotes', (req, res) => {

   //User = mongoose.model
    User.find({},(err, quotes) => {
      
     res.render('quotes', {arr:quotes});
   })
 })




app.post('/quotes', (req, res) => {
   const user = new User();
   user.name = req.body.fName;
   user.quote = req.body.fQuote;
   user.save()
      .then(newQuote => {
         console.log('Quotes added: ', newQuote)
         res.redirect('/')
      }) //will execute upon successfully inserting data in the database
        .catch(err => {
                     console.log("We have an error!", err);
                     // adjust the code below as needed to create a flash message with the tag and content you would like
                     for (var key in err.errors) {
                         req.flash('registration', err.errors[key].message);
                     }
                       res.redirect('/');
                 }); //will execute if there is an error.  
      
   // res.redirect('/')
});



