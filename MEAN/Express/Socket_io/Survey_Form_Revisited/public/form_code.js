//connect to socket.io on the backend

var socket = io.connect('http://localhost:8000');

//get and store the front end comms  name  comment button
var NameField =document.getElementById('name');
var CommentField =document.getElementById('comment');
var btn = document.getElementById('button');

var notification = document.getElementById('notification');

//Emit events

btn.addEventListener('click', function(){
    //send to web front_socket
    socket.emit('sending',{
        NameField: NameField.value,
        CommentField: CommentField.value
        
    });

    console.log('aqil')
});


//Listen for events (incoming messages)

socket.on('f', function(data){
    console.log('ali')
    notification.innerHTML = '<p><em>' + data + ' is typing a msg...</em></p>';
});
