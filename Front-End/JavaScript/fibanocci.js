var length = 8;
var n1 = 0;
var n2 = 1;
if (length === 1) {
    console.log(n1);
} else if (length === 2) {
    console.log(n1);
    console.log(n2);
} else {
    console.log(n1);
    console.log(n2);
    for (let index = 3; index <=  length; index++) {
    var n3 = n1+n2;
    console.log(n3);
    n1=n2;
    n2=n3;y
    }  
}