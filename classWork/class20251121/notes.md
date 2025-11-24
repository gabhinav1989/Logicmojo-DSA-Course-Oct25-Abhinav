
Recurrsion
---------------------------

What is a function? 
    Some block of code that can be called multiple times to perform same action on different values.
    Write once and call it multiple times with different arguments.
    Avoids redundant code.

Recursion is a lazy function that makes a clone of itself and calls itself.
Without a base condition, recursion is infinite. 

Any recursion program can be written using for loop or while loop. But to use loops, you need to create your own call stack and manually back track which is difficult.
But some programs are easy to write with recursion.

Call stack
last in first out.
backtracking is done using recursion.

Example: 
function print1ton(i, n){
    if(i>n){
        return;
    }
    console.log(i);
    print1ton(i+1, n);
}

print1ton(1, 10);

Note that in recurrsion, order matters.
For example the above program prints differently from below program.
function print1ton(i, n){
    if(i>n){
        console.log("returning" + i);
        return;
    }
    print1ton(i+1, n);
    console.log(i);
}

Challenge: print i without using + sign.

Fibonacci series
function fib(n){
    // Base cases
    if(n <= 0){
        return 0;
    }
    if(n == 1){
        return 1;
    }
    // Recursive case: fib(n) = fib(n-1) + fib(n-2)
    return fib(n-1) + fib(n-2);
}

this doesn't work after 45 in browsers at least since it takes too much time.

So to avoid that, we could use dynamic programming by using a map. 

let map = {};
function fib(n){
       // Base cases
    if(n <= 0){
        return 0;
    }
    if(n == 1){
        return 1;
    }
    if(map[n] != undefined){
        return map[n];
    }
    map[n] = fib(n-1) + fib(n-2);
    return map[n];
}
this sis called memoization.

Space complexity - Auxiliary space complexity.
Recurssion problems: 
Maximum call stack exceeded.
A print with a recursion uses extra space.
dynamic programming, 
tabulation method.

Leetcode 78
