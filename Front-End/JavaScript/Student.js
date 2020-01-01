// var person =  {
//      adhar : 4371604372222
// }

// var personPan = {
//     pan : 123456789
// }

// var student = {
//     ...person,
//     ...personPan,
//     id: 1234,
//     name: "surajkhan",
//     degree: "BE Pass",
//     phone: 7353181715
// }

// console.log(student.name);
// console.log(student.degree);
// console.log(student.adhar);
// console.log(student.pan);

// oBJECT wITHN the Object
var student = {
    
    id: 1234,
    name: "surajkhan",
    degree: "BE Pass",
    phone: 7353181715,
    address : {
        city : 'bgm',
        state : 'karnataka'
    }
}

console.log(student.address.city);

for (const x in student) {
    console.log(x +" :"+ student[x]);

}
