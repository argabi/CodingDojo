using Microsoft.AspNetCore.Mvc;// for inhintence Controller class

namespace HelloMVC
{
    public class HomeController : Controller
    {
        //the folder name beforeControler like "HomeController"
        //the folder name must be "Home" inside the Views folder


        //***** the respond always be a method ***********************
        
        //**** Requests ****

        //localhost:5000/
        [Route("")]//Root
        [HttpGet] //Get | Post
        public string Index() // response
        {
            return "Hello From Controller From Controller root route , Index method";
        }

        //localhost:5000/hello
        [Route("hello")]//hello
        [HttpGet] //Get
        public string HelloFromController() // response
        {
            return "Hi againe";
        }


    }
}