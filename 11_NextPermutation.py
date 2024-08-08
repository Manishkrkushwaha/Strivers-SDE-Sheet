'''

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

'''
# Next Permutation

# Brute force approach
# 1. Generate all possible permutations and sort them. Can be done using recursion
# 2. Linearly search the given arr
# 3. Return the next arr in the series

# Time comp = n!*n
# 5! = 120
# 15! = 10^12
# The time complexity can be very huge in some cases so we should look for an optimized method

# Optimized approach
# Intuitinon
# Following the example of a dictionary, where words are in a lexicographical order. There's some initial part of the word which matches the next permutation. We can see an increasing trend and then a break point. In the increasing trend no larger combination can be formed so we move ahead, until we find a decreasing trend.
# We can then replace that with the next larger value from the array we just traversed.
# After we just need to fill the remaining array with shortest possible combination

# Algorithm
# 1. Find a break point by traversing through the array from the reverse side. Also consider the edge case, that is if the given array is the last permutation. Then it's direct reverse will be our result.
# 2. Now we will replace the value with the just larger value from the right part of the arr.
# 3. Now we need to make the shortest possible combination from the remaining part of the array, since we know that from the back it is following an increasing trend so we can simply reverse the right part.

# Woah! We've now got our next permutation array


def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

def rev(arr, i, j):
    while(i < j):
        swap(arr, i, j)
        i += 1
        j -= 1

def next_permutation(arr):
    n = len(arr)
    
    # first find the break point in the array
    
    i = n-1
    
    while(i > 0):
        if(arr[i] > arr[i-1]):
            break
        i -= 1
    
    i -= 1
    # check the edge case condn
    
    if(i < 0):
        rev(arr, 0, n-1)
        return
        
    # now find the element just larger than the break point value and swap it with that index
    
    j = n-1
    
    while(arr[j] <= arr[i]):
        j -= 1

    swap(arr, j, i)
    
    # Now we need to make the smallest possible permutation from the right part, since it is already in increasing order so we just need to reverse it
    
    rev(arr, i+1, n-1)
    
#  MAIN BODY

nums = []    
n = int(input('Enter the size of the array: '))

print('Enter the array: ')

while(n):
    nums.append(int(input()))
    n -= 1
    
next_permutation(nums)

print(nums)
