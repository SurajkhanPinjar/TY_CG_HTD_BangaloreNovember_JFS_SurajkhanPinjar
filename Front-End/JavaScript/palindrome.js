var num = 1221;
var n1 = num;
var rev = 0;
while (n1>0) {
    var rem = n1 % 10;
    rev = ( rev*10 )+rem;
    n1 = n1/10;
    console.log(rev);
}
console.log(rev);
if (num === rev) {
    console.log(`The given no ${num} is palindrome `);
    
} else {
    console.log(`The given no ${num} is  not palindrome `);
}