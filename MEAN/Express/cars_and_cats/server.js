// Express Cars and Cats witout EJS
const express = require("express");
const app = express();

app.listen(8000, () => console.log("listening on port 8000"));

//static folder - static content must go in the static folder including styles and static javascript files
app.use(express.static(__dirname + "/static"));
//////////////////////////////////////////////////////////////
//Routing

app.get('/', (request, response) => {
   res.render('index');
});