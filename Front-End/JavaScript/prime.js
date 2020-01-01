var a = 8;
var c = 0;
for (let i = 2; i < a-1 ;i++) {
    if (a%i === 0 ) {
        c++;
    }
}
    if (c === 0) {
        console.log(`The no ${a} is prime`);  
    } else {
        console.log(`The no ${a} is not prime`);
    }

    
    
