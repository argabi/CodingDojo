// idk why it is not working  :(

var express = require('express');
var socket = require('socket.io');

var app = express();
var server = app.listen(8000, function(){
    console.log("Listening on port 8000");
});

//create a folder to store static files
app.use(express.static('public'));

//setup socket
var io = socket(server);

io.on('connection', function(socket){
    console.log("Connected to socket 'connection'", socket.id);

    //chat event handler
    socket.on('sending', function(data){
        //where and what do we do? send it to the clients
        io.sockets.emit('f', 'data');
        console.log('i got sending')
    });

    socket.on('sending', function(data){
        //broadcast
        console.log('i got sending   broadcast')
        socket.broadcast.emit('typing', data); 
    });
});
