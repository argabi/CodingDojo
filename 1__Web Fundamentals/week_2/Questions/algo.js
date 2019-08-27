//Messy Math Mashup
function smessyMath(num)
{
 var sum =0;

 for(i=0;i<=num;i++)
 {
   if(i == (num/3))
   {
     return -1;
   }
   if(i%3 ==0)
   {
     continue; //skip
   }
    if(i%7 ==0)
    {
      sum+=i*2 // twice
    }
    else{
      sum+=i;
    }
 }
  return sum;
}

console.log(smessyMath(15))


/////////////////////////////////
function ali(num)
{
  while (num<1)
  {
    num *=10;
  }

var result =0;
 for(i = num.toString().length; i >=0 ; i--)
 {
   result=Math.floor( num /(Math.pow(10,i)) %10);
    if(result != 0)
    {
      return result;
    }
 }
}

console.log(ali(0.000054))