// Express assignment Cars and Cats using EJS
const express = require("express");
const app = express();

app.listen(8000, () => console.log("listening on port 8000"));
//static folder - static content must go in the static folder including styles and static javascript files
app.use(express.static(__dirname + "/static"));
//////////////////////////////////////////////////////////////
// Using Templates (EJS)  Embedded Javascript.
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
//////////////////////////////////////////////////////////////

//Routing

// request, response 
app.get('/', (request, response) => {
   res.render('index');
}); 

//req , res
app.get('/cars', (req, res) => {
  
   res.render('cars',{myName:'by Ali'});
}); 

app.get('/cats', (req, res) => {
  
   res.render('cats',{myName:'by Ali'});
}); 

app.get('/cars/new', (req, res) => {
  
   res.render('new',{myName:'by Ali'});
}); 



