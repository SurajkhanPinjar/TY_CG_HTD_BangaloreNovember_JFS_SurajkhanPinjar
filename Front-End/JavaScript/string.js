// // -------------CharCodeAt---------
// let message = 'good morning';
// console.log(message.charCodeAt(3));
// //-----------charAt---------------
// console.log(message.charAt(4));

// //--------------Split-------------
// let splitMsg = message.split('').reverse().join('');
// console.log(splitMsg);

// //------------Checking element -----------
// console.log(message.includes('hello'));
// console.log(message.includes('good'));

// //----------Case Manipulation--------------
// console.log(message.toUpperCase());
// console.log(message.toLowerCase());

// //-----------Sub String -----------------
// console.log(message.substr(0,5));

// //------------Check Length of String ----------
// console.log(message.length);


// //----------Rest Parameter-------------
// function add(...nums) {
//     let sum = 0;
//     for( let num of nums) {
//         sum = sum + num;
//     }
//     console.log('sum of the no is ' + sum);
// }

// add(12, 23, 45, 67);


//---------DESTRUCTURING-------------
let student = {
    id: 1234,
    name: 'surajkhan',
    age: 23
};

let { id, name , ...theRest} = student;

console.log(name);
console.log(id);
console.log(theRest);