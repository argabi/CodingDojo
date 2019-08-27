function rollOne() 
{
  var max =6;
  var min =1;
	return Math.floor(Math.random() * (max - min + 1)) + min;
}
function PlayFives(num)
{
  for(var i =1 ; i<=num ; i++)
  {
    var value = rollOne();
     console.log(value);
    if(value ==5)
    {
      console.log("That's good luck!")
    }
  }
}

function playStatistics()
{
  var max = rollOne() , min = max ;
  console.log(max)
  console.log(min)
  var value ;
  for(var i = 0; i<7 ;i++)
  { value = rollOne();
    if(value > max)
    {
      max = value;
    }
    else if (value< min)
    {
      min = value;
    }
  }
  console.log( "max: " + max , "min: "+min);
}


function playStatistics2()
{
  var max = rollOne();
  var min = max;
  var sum = max;
 
  var value=0;
  for(var i = 0; i<7 ;i++)
  {   
    value = rollOne();
    sum += value;
    if(value > max)
    {
      max = value;
    }
    else if (value< min)
    {
      min = value;
    } 
  }
  console.log( "max: " + max);
  console.log( "min: "+min);
  console.log( "sum: "+ sum);
}

function playStatistics3(num)
{
  var max = rollOne();
  var min = max ;
  var sum = max;
 
  var value=0 ;

  for(var i = 0; i<num ;i++)
  {   
    value = rollOne();
    sum += value;
    if(value > max)
    {
      max = value;
    }
    else if (value< min)
    {
      min = value;
    } 
  }
  console.log( "max: " + max);
  console.log( "min: "+min);
  console.log( "sum: "+ sum);
}

function playStatistics4(num)
{
  var max = rollOne();
  var min = max ;
  var sum = max;
 
  var value=0 ;

  for(var i = 0; i<num ;i++)
  {   
    value = rollOne();
    sum += value;
    if(value > max)
    {
      max = value;
    }
    else if (value< min)
    {
      min = value;
    } 
  }
  console.log( "max: " + max);
  console.log( "min: "+min);
  console.log( "avg: "+ sum/num);
}

playStatistics4(2);

//__________________________________________________________________________________________________________

// function rollOne() 
// {
//   var max =20;
//   var min =1;
// 	return Math.floor(Math.random() * (max - min + 1)) + min;
// }

function ali ()
{
  var arr = [];
  var max = rollOne();
  var min = max;
  var sum = max;
  
  arr.push(min);  //arr[0]
  for(var i = 1 ; i <20;i++)
  {
    arr.push(rollOne()); // arr[i]
    sum+=arr[i];

    if(arr[i] < min)
    {
      min = arr[i];
    }
    else if (arr[i] > max)
    {
      max = arr[i];
    }
    
    if(arr[i]==arr[arr.length -2])
    {
      console.log(arr)
      console.log("min= ",min);
      console.log("max= ",max);
      console.log("avg= ",sum/arr.length);
      console.log("#ofRolls= ",arr.length);
    break;
    }
  }
}

ali();