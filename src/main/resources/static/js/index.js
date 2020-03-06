// Section-7 Collapse---------------------------------------------------------
let plus = document.querySelectorAll('h6 .collapsed');
let show = document.querySelectorAll('#accordion .collapse');

let k = 5 , num = 0  ,bSn = 180;
function plusMinus(e,i){
    for(let j =0;j<show.length;j++){
        plus[j].firstElementChild.classList.add("fa-plus-square");
    }
    e.firstElementChild.classList.remove("fa-plus-square");
    e.firstElementChild.classList.add("fa-minus-square");
    if(i === k){
        if(num%2===0){
        e.firstElementChild.classList.add("fa-plus-square");
    }
        num++;
    }
    else num = 0;
    k = i;
}

for(let i = 0;i<plus.length;i++){
    setInterval(function(){ bSn++ },10);
    plus[i].onclick = function(){
        console.log(bSn);
        if(bSn > 140){
        plusMinus(plus[i],i);
        bSn = 0;
     } 
    }

    
} 
//-------------------------------------------------------------------------------