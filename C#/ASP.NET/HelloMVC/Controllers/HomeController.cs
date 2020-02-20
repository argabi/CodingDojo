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

            var contextParam = new { username = "ali_param", location = "KSA_param" }; // anonymous objects

            return RedirectToAction("HelloUser", contextParam); // method name "HelloUser" and passing the parametrs
        }

        // by Json for Front-End
        [HttpGet("json/{username}/{location}")]//hello
        public JsonResult HelloJason(string username, string location) /// this is better from then the above RedirectResult"
        {

            var response = new { user = username, place = location }; // anonymous objects
            //can be any onject return as response suck as array obkect string ..etc
            return Json(response);
        }

        // by all in one  __ interface --

        // public IActionResult Miixed()
        // {
        //   return View();
        //   return Json():
        //   return RedirectToAction();
        //   //etc      
        // }


        //****************************************************************************************************************************************
        //        ViewBag 
        // is using for passing date to html page

        /*  YourController.cs
        [HttpGet("")]
        public IActionResult Index()
        {
            // Here we assign the value "Hello World!" to the property .Example
            // Property names are arbitrary and can be whatever you like
            ViewBag.Example = "Hello World!";
            return View();
        }
        */

        /* Index.cshtml
        <h1>@ViewBag.Example</h1>
        */

        /*  Index.cshtml
        @{
            string LocalString = ViewBag.Example + " Good to see you!";
        }
        <h1>@LocalString</h1>
        */

        [HttpGet("/bag")]
        public IActionResult View_Bag()
        {
            DateTime CurrentTime = DateTime.Now;

            // Here we assign the value "Hello World!" to the property .ali
            // Property names are arbitrary and can be whatever you like
            ViewBag.ali = "Hello World! the ali";
            ViewBag.Example = CurrentTime;
            return View("HomeHTML"); //html page
        }

        //____________________________________   POST   ____________________________________
        //for Method_HTML_Page
        [HttpGet("post")]
        public IActionResult rendring_Method_HTML_Page()
        {
            return View("Method_HTML_Page");
        }

        //post method
        [HttpPost("post")] // from html form action="/post" method="post"
        public IActionResult Method_HTML_Page(string TextField, int NumberField)
        {
            Console.WriteLine(TextField + " | " + NumberField);
            return RedirectToAction("Index");//index method ( i used the best )
        }








    }
}