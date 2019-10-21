//Assignment: 1955 API

/*
GET '/' will serve up the full collection of people born in 1955
GET '/new/:name/' will add a name into the database. So adding Steve Jobs to our database, you'd type in the URL 'localhost:8000/new/Steve Jobs'
GET '/remove/:name/' will delete a name from the database.
GET '/:name' will bring up the document of that particular person.
*/

const express = require("express");
const mongoose = require('mongoose');
const app = express();
app.use(express.json());
const server = app.listen(8000, () => console.log("listening on port 8000"));

mongoose.connect('mongodb://localhost/1955API_DB', {
useUnifiedTopology: true,
useNewUrlParser: true,
});

/// mangoDB
const   NameSchema = new mongoose.Schema({
    name: {type: String}},
    {timestamps: true}); //createdAt // updatedAt

const User = mongoose.model('User', NameSchema);
///////////////////////////////////////////////
   
// --- Ruoting ---

//load all names
app.get('/', (req, res) => {
    User.find()
        .then(users => res.json(users))
        .catch(err => res.json(err));
});

//add a name in DB
app.get('/new/:name/', (req, res) =>{
    var user = new User({ name: req.params.name });
    user.save( (errorsNewMessage) => {
        if (errorsNewMessage) {
            res.redirect("/");
        } 
        else
        {
            console.log('user created', user)
            res.redirect("/");
        }
    });
});

//search by a Name in DB
app.get('/:name/',  (req, res) => {
    User.findOne({name : req.params.name})
    
    .then(users => res.json(users))
    .catch(err => res.json(err));
});

//delete a name from DB
app.get('/remove/:name/',  (req, res) => {

    User.findOneAndRemove({name : req.params.name})
   
    .then(data => {
        console.log('user deleted:', user)
        res.redirect('/'); })
    .catch(err => { res.redirect('/') });
});

