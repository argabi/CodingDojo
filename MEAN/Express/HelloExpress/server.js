const express = require("express");
const app = express();

// routing
app.get('/', (request, response) => {
   response.send("Hello Express");
});

app.get("/users", (req, res) => {
    // hard-coded user data
    var users_array = [
        {name: "Michael", email: "michael@codingdojo.com"}, 
        {name: "Jay", email: "jay@codingdojo.com"}, 
        {name: "Brendan", email: "brendan@codingdojo.com"}, 
        {name: "Andrew", email: "andrew@codingdojo.com"}
    ];
    res.render('users', {users: users_array});
})



//static folder - static content must go in the static folder including styles and static javascript files
app.use(express.static(__dirname + "/static")); //localhost:8000/main.html - ali

// Using Templates (EJS)  Embedded Javascript.
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');




//////////////////////////////////////////////////////////////////
app.listen(8000, () => console.log("listening on port 8000"));
