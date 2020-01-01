
//--------Destructuring in Array----------
var marks = [20, 30, 50, 70];

var [maths, social, java, ...l1] = marks;
console.log(maths);
console.log(social);
console.log(l1);


//---------DESTRUCTURING in String-------------
let student = {
    id: 1234,
    name: 'surajkhan',
    age: 23
};

let { id, name , ...theRest} = student;

console.log(name);
console.log(id);
console.log(theRest);