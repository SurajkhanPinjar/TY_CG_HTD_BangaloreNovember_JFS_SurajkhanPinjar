var date = new Date();
console.log("date :"+date.getDate());
console.log("month :"+date.getMonth());
console.log("Time :"+date.getTime());
console.log("Hours :" +date.getHours);


setInterval(() => {
    document.getElementById("Todaysdate").innerHTML = 
    `Date :: ${date.getDate()}-${date.getMonth()}-${date.getFullYear()}
    Time :: ${date.getHours()}-${date.getMinutes()}-${date.getSeconds()}` },1);

