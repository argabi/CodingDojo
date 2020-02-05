using System;
using System.Collections.Generic; //added

namespace CollectionsPractice
{
    class Program
    {
        static void Main(string[] args)
        {
            //*** Three Basic Arrays
            Console.WriteLine("--- Three Basic Arrays ---");
            int [] num0to9Array = new int [10];
            for(int i =0;i<10;i++)
            {
                num0to9Array[i]=i;
            }
            foreach(var num in num0to9Array)
            {
                Console.WriteLine(num);
            }

            string []namesArray ={"Tim", "Martin", "Nikki", "Sara"};
            foreach(var thename in namesArray)
            {
                Console.WriteLine(thename);
            }

            bool [] trueFalseArray= new bool[10];
            trueFalseArray [0] = true; //starting with true
            for(int i =1;i<10;i++)
            {
               trueFalseArray [i] = !trueFalseArray [i-1]; // reverse the previous value T to F , F to T
            }
            foreach(var theTF in trueFalseArray)
            {
                Console.WriteLine(theTF);
            }

            //*** List of Flavors
            Console.WriteLine("--- List of Flavors ---");
            List<string> iceCream = new List<string>();
            iceCream.Add("1-flavors ");
            iceCream.Add("2-flavors ");
            iceCream.Add("3-flavors ");
            iceCream.Add("4-flavors ");
            iceCream.Add("5-flavors ");

            Console.WriteLine($"IceCream List Length is {iceCream.Count}");
            Console.WriteLine($"third flavor index3 is {iceCream[3]}");
            iceCream.RemoveAt(3);
            Console.WriteLine($"IceCream List Length is {iceCream.Count} after removed index3");

            //*** User Info Dictionary
            Console.WriteLine("\n--- User Info Dictionary ---\n");
            Dictionary<string,string> theDict = new Dictionary<string,string>();
            Random rand = new Random();

            int selectedinDexRandom = rand.Next(num0to9Array.Length);//selectedinDexRandom randome inidex from the size of it
            theDict.Add("num0to9Array",$"index slected is {selectedinDexRandom} has value= {num0to9Array[selectedinDexRandom]}");

            selectedinDexRandom = rand.Next(namesArray.Length);//selectedinDexRandom randome inidex from the size of it
            theDict.Add("namesArray",$"index slected is {selectedinDexRandom} has value= {namesArray[selectedinDexRandom]}");

            selectedinDexRandom = rand.Next(trueFalseArray.Length);//selectedinDexRandom randome inidex from the size of it
            theDict.Add("trueFalseArray",$"index slected is {selectedinDexRandom} has value= {trueFalseArray[selectedinDexRandom]}");

            selectedinDexRandom = rand.Next(iceCream.Count); //selectedinDexRandom randome inidex from the size of it
            theDict.Add("iceCream",$"index slected is {selectedinDexRandom} has value= {iceCream[selectedinDexRandom]}");

            foreach(var oneDict in theDict)
            {
                Console.WriteLine(oneDict.Key + " - " + oneDict.Value);
            }
        }
    }
}



























