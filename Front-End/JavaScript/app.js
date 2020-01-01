// console.log('hello'); 

// variable Declaration
var a;

// var Initialization
a = 100;

console.log('value of a is  ' + a );

console.log(typeof a);


var name = ' surajkhan ';
console.log('name is :'+name);
console.log(typeof name);

var age = 23;
console.log('age is :'+age)

var details = `The Name is ${name}  and age is ${age}`;
console.log(details);

console.log(`The sum of 10 and 11 is ${10+11}`);

var sampleText = 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Porro, facere eaque corporis minus, unde ducimus nostrum corrupti quibusdam explicabo' 
+'illum nobis vitae maxime, harum eius qui provident reprehenderit aperiam exercitationem' ;

console.log(sampleText);

var icompassCleared = true;
console.log(typeof icompassCleared);

var b ;
console.log(typeof b);

var c = null;
console.log(c);
console.log(typeof c);

if (true == 'true') {
    console.log('true block');
} else {
    console.log('false block');
    
}

if (null == undefined) {
    console.log('true block');
} else {
    console.log('False. block');
}

// // alert('yes im fine :)');
// confirm('are you sure to proceed ');


// var userConfirmation = confirm('are u sure to proceed');

// if (userConfirmation) {
//     console.log('ok proceed');
    
// } else {
//    console.log('cancel'); 
// }

// var userInput = prompt('please Enter your name ');
// console.log(userInput);

// document.write('welcome to Java Script :)');

// --------Funcion calling------------
// var a = 'xyz';
// function demo() {
//     console.log('function demo is being called :)');
//     var b = 100;
//     console.log(a);
// }
// console.log(b); 
// b is not defined hence it throws error 
// demo();

function add(a,b) {
    return a+b;
}
console.log(add(10,20));

//----------Anonymous Functions----------
var test = function() {
    console.log("Anonymous Called");

}
test();

//---------IMMEDIATELY INVOKED FUNCTION EXPRESSION----------
// (function() {
//     var name = "surajkhan";
//     console.log('name '+name);
//     console.log('IIFE running ');
// })
// ();


// (function(x,y) {
//     var name = "surajkhan";
//     console.log('name '+name);
//     console.log('IIFE running ');
// })
// (10,20,);


//-----Call Back Functions------
function sample(x) {
    console.log('samole functon called');
    x();
    console.log("sample function ended");
}

sample( function() {
    console.log('call back function running ');
});