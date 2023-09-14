console.log("I like pizza");

// Pop up
// window.alert("I love pizza");

// This is comment
/*
    This is multiline comment
*/


// Variables 
// 1. Declaration (var, let, const)
// 2. Assigment ( = )

let age = 10;

let bae = age - 1;
console.log(age + bae);

function max1(arr) {
    let max = arr[0];
    for (let i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }
  
  console.log(max1([3, 5, 4, 6, 5])); // Output: 6

  function countingWords(arr, ignoreCase = false) {
    const counts = {};
    arr.forEach(word => {
      const wordToCount = ignoreCase ? word.toLowerCase() : word;
      counts[wordToCount] = counts[wordToCount] ? counts[wordToCount] + 1 : 1;
    });
    return counts;
  }
  
  console.log(countingWords(['hi', 'hi', 'hello', 'world', 'hello', 'hi', 'greetings', 'World'])); 
  // Output: {hi: 3, hello: 2, world: 1, greetings: 1, World: 1}
  

  document.getElementsByClassName("favorite-button").onclick = function() {
    
  }