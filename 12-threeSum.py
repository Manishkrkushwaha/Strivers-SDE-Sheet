'''

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.
''' 

'''

 ######### 3 Sum problem ###########

# Brute force approach

1. Generate all possible triplets
2. Check if sum is zero.
3. While storing to avoid duplicates we can use this strategy - sort them and store them in a set, since searching in a set takes less time.

TC - O(N^3*log(no. of unique triplets)
SC - O(No. of uniquq triplets)

# Better approach

1. We can run the two loops as in the previous approach
2. Using the formula -(a1 + a2), we can tell what our third element will be.
3. As we progress j ahead we can store the values in a set(), and then accordingly check if the required value is there or not.
4. If the value is there, it means that this particular triplet is part of the soln.
5. Now we use the strategy used in the previous scenario to store unique triplets.

TC - O(N^3*log(no. of unique triplets)
SC - O(No. of uniquq triplets)

# Best approach. 2 pointer approach

Intuition - While storing the array in set we were sorting it first. Why not store the array first and then store the values. If we store in the correct order, they will always be in ascending order.

1. Run single 'for' loop.
2. Define start and end index variables to traverse from the index after i and end to traverse from the array end.
3. As we are traversing we create a variable sum, if the value of sum is less than 0, we know that we need to increase it's value. So we move the start var ahead.
4. If sum < 0, then accordingly we move end behind so as to deacrease the value of sum
5. If sum == 0, then we need to change both start and end. Since the values could be repeating we need to move them to non repeating point.
6. While incrementing i we also need to take care that repeating values of i are passed.

TC - O(NlogN + N^2)
SC - O(1)

'''

def threeSum(arr):
    ans = []
    n = len(arr)
    arr.sort()
    for i in range(0, n-2):
        s = i+1
        e = n-1
        if(i != 0 and arr[i] == arr[i-1]):
            continue
        while s < e:
            sum = arr[i] + arr[s] + arr[e]
            if sum < 0:
                s += 1
            elif sum > 0:
                e -= 1
            else:
                ans.append([arr[i], arr[s], arr[e]])
                s += 1
                e -= 1
                while(s < e and arr[s-1] == arr[s]):
                    s += 1
    
    print(ans)
    
arr = [-2,-2,-2,-1,-1,0,0,1,1,2]
threeSum(arr)