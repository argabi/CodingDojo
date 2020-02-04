using System;

namespace FirstCSharp
{
    
    class Program
    {
       
        static void Main(string[] args)
        {
             Random rand = new Random();
            Console.WriteLine(rand.Next(2,8));
        }
    }
}
