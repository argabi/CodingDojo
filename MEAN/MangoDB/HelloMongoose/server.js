// Express assignment Cars and Cats using EJS
const express = require("express");
const app = express();
const mongoose = require('mongoose');

//Note: If you connect to a database that doesn't exist, Mongoose will create the DB for you!
mongoose.connect('mongodb://localhost/name_of_your_DB', { useNewUrlParser: true }); //Connect Mongoose to MongoDB

// Mongoose Schema --------------------------------------------------------------------------
const UserSchema = new mongoose.Schema({
   name: String,
   age: Number
})
// create an object to that contains methods for mongoose to interface with MongoDB
const User = mongoose.model('User', UserSchema);
//--------------------------------------------------------------------------





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



//Routing

// request, response 
app.get('/', (request, response) => {
   response.render('index')
});



app.post('/users', (req, res) => {
   const user = new User();
   user.name = req.body.fName;
   user.age = req.body.age;
   user.save()
      .then(newUserData => console.log('user created: ', newUserData)) //will execute upon successfully inserting data in the database
      .catch(err => console.log(err)); //will execute if there is an error.  

   res.redirect('/')
});
