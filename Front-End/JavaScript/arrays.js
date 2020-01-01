// var technologies = [ "java", "servlets", "bs", "angular", "CSS","coreJava", 12345, true, null];
// console.log(technologies[2]);

// //-----------For of Loops------------
// for (let  technology of technologies) {
//     console.log(technologies);
    
// }


// for (let  x in technologies) {
//    console.log('index is '+x +" technologies "+ technologies[x]);

// }



// //-----------ForEach-----------------
// technologies.forEach ((value) => {
//     console.log(value);

// });

// //------indexOf()------------------
// console.log("index of tech :"+ technologies.indexOf('bs'));

// //---------pop()------------
// console.log('before pop :' +technologies);
// console.log(technologies.pop());
// console.log('after pop :' +technologies);

// //-----------push()-------------
// console.log("before push :"+ technologies );
// console.log(technologies.push("Testing"));
// console.log("after pushing :"+technologies);

// //----------Shifting-------------
// console.log("before shift :"+ technologies);
// console.log(technologies.shift());
// //returns the oth index and remove it
// console.log("after shifting :"+ technologies);

// //----------Un-Shifting-------------
// console.log("before Un-shift :"+ technologies);
// console.log(technologies.unshift('selenium','css'));
// //returns the oth index and remove it
// console.log("after un-shifting :"+ technologies);

// //-----------Splice----------------
// technologies.splice(2,0, 'bootstrap', 'js','corejava');
// console.log("after splice "+technologies );
// //-----------splice deleting-----------
// technologies.splice(technologies.indexOf(1234),2)
// console.log("after deleted :"+ technologies);

// //------------length-----------
// console.log("length of tech :"+technologies.length);

// //------------rev of array-------------
// technologies.reverse();
// console.log("reverse array "+technologies);


//-----------filter--------------
// let marks = [35, 22, 45, 60, 75,10];
// console.log(marks);

// var filterArray = marks.filter((value, index , array) =>{
//     return value >40;
// });

// console.log(filterArray.length);


// let marks = [ 20, 30, 40, 40, 50, 60, 70, 70];
// // console.log(marks);

// var filterArray = marks.filter((value, index, array) => {
//     if (marks.indexOf(value)===index) {
//         return true;
        
//     } else{
//         return false;
//     }
// });
// console.log(filterArray);


// let newArray = x.map((value, index, value) => {

//     return {
//         index1 :index ,
//         value1 : value
//     };
    
// });
// console.log(newArray);

//------------Ascending Order ---------------- 
 let marks = [ 20, 30, 40, 40, 50, 60, 70, 70];
 let ascendingOrder = marks.sort((a,b) => {
    return a-b;
});
console.log(ascendingOrder);



//------------Descending Order ----------------
let descendingOrder = marks.sort((a,b) => {
    return b-a;
});
console.log(descendingOrder);



