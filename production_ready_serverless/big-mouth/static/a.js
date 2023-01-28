function* gen(){
    yield 'w';
    yield 'o';
    yield 'r';
    yield 'l';
    yield 'd';
}

const a =gen()
for(let i of a){
    console.log(i)
}






    
    
