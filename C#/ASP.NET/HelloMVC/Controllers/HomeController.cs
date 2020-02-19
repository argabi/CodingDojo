using System;
using Microsoft.AspNetCore.Mvc;// for inhintence Controller class

namespace HelloMVC
{
    public class HomeController : Controller
    {
        //the folder name beforeControler like "HomeController"
        //the folder name must be "Home" inside the Views folder


        //***** the respond always be a method ***********************

        //**** Requests ****
        // -------------------------------------------  String  -------------------------------------------

        //localhost:5000/
        //Root 
        [HttpGet("")]//Get | Post..etc
        public string Index() // response
        {
            return "Hello From Controller From Controller root route , Index method";
        }

        // % parameters
        //localhost:5000/users/???
        [HttpGet("users/{username}/{location}")] // same var MUST
        public string HelloUser(string username, string location) // same var MUST
        {
            return $"Helollo {username} from {location}"; //http://localhost:5000/users/ali/KSA
        }



        // -------------------------------------------  HTML  -------------------------------------------

        [HttpGet("html")]//hello
        public ViewResult HomeHTML() // ViewResult for Rendering HTML page
        {

            // Views = Must be as it i`s
            // /Home follwed by Controler Name "HomeController"
            // Views/Home/HomeHTML.cshtml
            //if not there it will look inside Shared folder
            // Views/Shared/HomeHTML.cshtml
            return View("HomeHTML"); // file  .cshtml
        }


        // -------------------------------------------  Redirecting  -------------------------------------------
        //by path
        [HttpGet("helloPath")]//helloPath
        public RedirectResult HelloPath() // response
        {
            return Redirect("/");//url Path  redirect to root
        }

        //by method
        [HttpGet("hello")]//hello
        public RedirectToActionResult Hello() /// this is better from then the above RedirectResult"
        {
            Console.WriteLine("ALi  redirecting...");
            return RedirectToAction("Index"); // method name "Index"
        }

        //by method nad paramets
        [HttpGet("helloParam")]//hello
        public RedirectToActionResult HelloParam() /// this is better from then the above RedirectResult"
        {
            Console.WriteLine("ALi  redirecting by Param...");

            var contextParam = new{ username="ali_param", location="KSA_param"}; // annonimiose objects

            return RedirectToAction("HelloUser",contextParam); // method name "HelloUser" and passing the parametrs
        }

        // by all in one  __ interface --

        // public IActionResult Miixed()
        // {
        //   return View();
        //   return Json():
        //   return RedirectToAction();
        //   //etc      
        // }



    }
}