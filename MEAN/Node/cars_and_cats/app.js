// Assignment: Cars and Cats

const http = require('http');
const fs = require('fs');
const server = http.createServer(function (request, response){
    console.log('client request URL: ', request.url);
    
    // this is how we do routing:
    if(request.url === '/cars') 
    {
        fs.readFile('./views/cars.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});  // send data about response
           
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    else if(request.url === '/cars/new') 
    {
        fs.readFile('./views/new.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});  // send data about response
           
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }

    else if(request.url === '/cats') 
    {
        fs.readFile('./views/cats.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});  // send data about response
           
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    /////////////////////// Images
    else if(request.url === '/images/car_1.jpg'){
        // notice we won't include the utf8 encodingcopy
        fs.readFile('./images/car_1.jpg', function(errors, contents){
            response.writeHead(200, {'Content-type': 'image/jpg'});
            response.write(contents);
            response.end();
        });
    }

    else if(request.url === '/images/car_2.jpg'){
        // notice we won't include the utf8 encodingcopy
        fs.readFile('./images/car_2.jpg', function(errors, contents){
            response.writeHead(200, {'Content-type': 'image/jpg'});
            response.write(contents);
            response.end();
        });
    }

    else if(request.url === '/images/cat_1.jpg'){
        // notice we won't include the utf8 encodingcopy
        fs.readFile('./images/cat_1.jpg', function(errors, contents){
            response.writeHead(200, {'Content-type': 'image/jpg'});
            response.write(contents);
            response.end();
        });
    }

    else if(request.url === '/images/cat_2.jpg'){
        // notice we won't include the utf8 encodingcopy
        fs.readFile('./images/cat_2.jpg', function(errors, contents){
            response.writeHead(200, {'Content-type': 'image/jpg'});
            response.write(contents);
            response.end();
        });
    }

        //////////////////////////////////////// CSS
        else if(request.url === '/stylesheets/style.css'){
            fs.readFile('./stylesheets/style.css', 'utf8', function(errors, contents){
             response.writeHead(200, {'Content-type': 'text/css'});
             response.write(contents);
             response.end();
            })
          }
        

    else
    {
        fs.readFile('./views/page404.html', 'utf8', function (errors, contents){
            response.writeHead(200, {'Content-Type': 'text/html'});  // send data about response
            response.write(contents);  //  send response body
            response.end(); // finished!
        });
    }
    
});
// tell your server which port to run on
server.listen(7077);
// print to terminal window
console.log("Running in localhost at port 7077");
