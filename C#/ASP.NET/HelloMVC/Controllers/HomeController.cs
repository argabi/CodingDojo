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
        [HttpGet("")]//Root //Get | Post..etc
        public string Index() // response
        {
            return "Hello From Controller From Controller root route , Index method";
        }

        //localhost:5000/hello
        [HttpGet("hello")]//hello
        public string HelloFromController() // response
        {
            return "Hi againe";
        }

        //localhost:5000/users/???
        [HttpGet("users/{username}/{location}")] // same var MUST
        public string HelloUser(string username ,string location) // same var MUST
        {
            return $"Helollo {username} from {location}"; //http://localhost:5000/users/ali/KSA
        }

    }
}