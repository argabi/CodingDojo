//
const express = require("express");
const app = express();
//////////////////////////////////////////////
//port number
const server = app.listen(8000, () => console.log("listening on port 8000"));
//static folder path
app.use(express.static(__dirname + "/static"));
//////////////////////////////////////////////
// ejs 
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
//////////////////////////////////////////////
//Socket
const io = require('socket.io')(server);

//////////////////////////////////////////////
//////////////////////////////////////////////

io.on('connection', function (socket) { //2
  
    socket.emit('greeting', { msg: 'Greetings, from server Node, brought to you by Sockets! -Server' }); //3
    socket.on('thankyou', function (data) { //7
      console.log(data.msg); //8 (note: this log will be on your server's terminal)
    });
      
  });


////////////////// Routing ///////////////////

//index
app.get('/', (req, res) => {
   res.render("index")
});

