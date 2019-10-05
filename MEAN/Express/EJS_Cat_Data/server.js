const express = require("express");
const app = express();
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
   res.redirect("/cats")
});

//cats
app.get('/cats', (req, res) => {
    res.render('cats');
 });


 app.get('/1', (req, res) => {
     context ={
         'catNum':1,
         'nameCat':'Olever',
         'ageCat' :5,
         'sleepTime':'8 PM'
     }
    res.render('details',context);
 });

 app.get('/2', (req, res) => {
    context ={
        'catNum':2,
        'nameCat':'Nani',
        'ageCat' :7,
        'sleepTime':'12 AM'
    }
   res.render('details',context);
});