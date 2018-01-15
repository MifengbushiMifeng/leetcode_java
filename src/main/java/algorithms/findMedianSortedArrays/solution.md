
https://leetcode.com/problems/median-of-two-sorted-arrays/solution/

To solve this problem, we need to understand "What is the use of median". In statistics, the median is used for:

    Dividing a set into two equal length subsets, that one subset is always greater than the other.


If we understand the use of median for dividing, we are very close to the answer.

First let's cut __A__ into two parts at a random position _i_:

             left_A              |        right_A
        A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
        
Since __A__ has mm elements, so there are m+1m+1 kinds of cutting (i = 0 \sim mi=0∼m).

And we know:

    len(left_A)=i,len(right_A)=m−i.
    
    Note: when i = 0i=0, \text{left\_A}left_A is empty, and when i = mi=m, \text{right\_A}right_A is empty.
    
With the same way, cut __B__ into two parts at a random position _j_:

          left_B             |        right_B
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
    
Put left_ __A__ and left_ __B__ into one set, and put right_ __A__ and right_ __B__ into another set. 

Let's name them left_ __part__ and right_ __part__:

          left_part          |        right_part
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
    
If we can ensure:

    1. len(left_part)=len(right_part)
    2. max(left_part)≤min(right_part)
then we divide all elements in \{\text{A}, \text{B}\}{A,B} into two parts with equal length, and one part is always greater than the other. Then

\text{median} = \frac{\text{max}(\text{left}\_\text{part}) + \text{min}(\text{right}\_\text{part})}{2} median=
​2
​
​max(left_part)+min(right_part)
​​ 

To ensure these two conditions, we just need to ensure:

i + j = m - i + n - ji+j=m−i+n−j (or: m - i + n - j + 1m−i+n−j+1)
if n \geq mn≥m, we just need to set:  i=0∼m, j=m+n+12−i i=0∼m, j=m+n+12−i

\text{B}[j-1] \leq \text{A}[i]B[j−1]≤A[i] and \text{A}[i-1] \leq \text{B}[j]A[i−1]≤B[j]

ps.1 For simplicity, I presume \text{A}[i-1], \text{B}[j-1], \text{A}[i], \text{B}[j]A[i−1],B[j−1],A[i],B[j] are always valid even if i=0i=0, i=mi=m, j=0j=0, or j=nj=n. I will talk about how to deal with these edge values at last.

ps.2 Why n \geq mn≥m? Because I have to make sure jj is non-negative since 0 \leq i \leq m0≤i≤m and j = \frac{m + n + 1}{2} - ij=
​2
​
​m+n+1
​​ −i. If n < mn<m, then jj may be negative, that will lead to wrong result.

So, all we need to do is:

Searching ii in [0, m][0,m], to find an object ii such that:

\qquad \text{B}[j-1] \leq \text{A}[i]\ B[j−1]≤A[i]  and \ \text{A}[i-1] \leq \text{B}[j],\  A[i−1]≤B[j],  where j = \frac{m + n + 1}{2} - ij=
​2
​
​m+n+1
​​ −i

And we can do a binary search following steps described below:

Set \text{imin} = 0imin=0, \text{imax} = mimax=m, then start searching in [\text{imin}, \text{imax}][imin,imax]
Set i = \frac{\text{imin} + \text{imax}}{2}i=
​2
​
​imin+imax
​​ , j = \frac{m + n + 1}{2} - ij=
​2
​
​m+n+1
​​ −i
Now we have \text{len}(\text{left}\_\text{part})=\text{len}(\text{right}\_\text{part})len(left_part)=len(right_part). And there are only 3 situations that we may encounter:

\text{B}[j-1] \leq \text{A}[i]B[j−1]≤A[i] and \text{A}[i-1] \leq \text{B}[j]A[i−1]≤B[j] 
Means we have found the object ii, so stop searching.

\text{B}[j-1] > \text{A}[i]B[j−1]>A[i] 
Means \text{A}[i]A[i] is too small. We must adjust ii to get \text{B}[j-1] \leq \text{A}[i]B[j−1]≤A[i].
Can we increase ii?
      Yes. Because when ii is increased, jj will be decreased.
      So \text{B}[j-1]B[j−1] is decreased and \text{A}[i]A[i] is increased, and \text{B}[j-1] \leq \text{A}[i]B[j−1]≤A[i] may
      be satisfied.
Can we decrease ii?
      No! Because when ii is decreased, jj will be increased.
      So \text{B}[j-1]B[j−1] is increased and \text{A}[i]A[i] is decreased, and \text{B}[j-1] \leq \text{A}[i]B[j−1]≤A[i] will
      be never satisfied.
So we must increase ii. That is, we must adjust the searching range to [i+1, \text{imax}][i+1,imax].
So, set \text{imin} = i+1imin=i+1, and goto 2.

\text{A}[i-1] > \text{B}[j]A[i−1]>B[j]:
Means \text{A}[i-1]A[i−1] is too big. And we must decrease ii to get \text{A}[i-1]\leq \text{B}[j]A[i−1]≤B[j].
That is, we must adjust the searching range to [\text{imin}, i-1][imin,i−1].
So, set \text{imax} = i-1imax=i−1, and goto 2.

When the object ii is found, the median is:

\max(\text{A}[i-1], \text{B}[j-1]), \ max(A[i−1],B[j−1]),  when m + nm+n is odd

\frac{\max(\text{A}[i-1], \text{B}[j-1]) + \min(\text{A}[i], \text{B}[j])}{2}, \
​2
​
​max(A[i−1],B[j−1])+min(A[i],B[j])
​​ ,  when m + nm+n is even

Now let's consider the edges values i=0,i=m,j=0,j=ni=0,i=m,j=0,j=n where \text{A}[i-1],\text{B}[j-1],\text{A}[i],\text{B}[j]A[i−1],B[j−1],A[i],B[j] may not exist. Actually this situation is easier than you think.

What we need to do is ensuring that \text{max}(\text{left}\_\text{part}) \leq \text{min}(\text{right}\_\text{part})max(left_part)≤min(right_part). So, if ii and jj are not edges values (means \text{A}[i-1], \text{B}[j-1],\text{A}[i],\text{B}[j]A[i−1],B[j−1],A[i],B[j] all exist), then we must check both \text{B}[j-1] \leq \text{A}[i]B[j−1]≤A[i] and \text{A}[i-1] \leq \text{B}[j]A[i−1]≤B[j]. But if some of \text{A}[i-1],\text{B}[j-1],\text{A}[i],\text{B}[j]A[i−1],B[j−1],A[i],B[j] don't exist, then we don't need to check one (or both) of these two conditions. For example, if i=0i=0, then \text{A}[i-1]A[i−1] doesn't exist, then we don't need to check \text{A}[i-1] \leq \text{B}[j]A[i−1]≤B[j]. So, what we need to do is:

Searching ii in [0, m][0,m], to find an object ii such that:

(j = 0(j=0 or i = mi=m or \text{B}[j-1] \leq \text{A}[i])B[j−1]≤A[i]) and
(i = 0(i=0 or j = nj=n or \text{A}[i-1] \leq \text{B}[j]),A[i−1]≤B[j]), where j = \frac{m + n + 1}{2} - ij=
​2
​
​m+n+1
​​ −i

And in a searching loop, we will encounter only three situations:

(j = 0(j=0 or i = mi=m or \text{B}[j-1] \leq \text{A}[i])B[j−1]≤A[i]) and
(i = 0(i=0 or j = nj=n or \text{A}[i-1] \leq \text{B}[j])A[i−1]≤B[j]) 
Means ii is perfect, we can stop searching.
j > 0j>0 and i < mi<m and \text{B}[j - 1] > \text{A}[i]B[j−1]>A[i] 
Means ii is too small, we must increase it.
i > 0i>0 and j < nj<n and \text{A}[i - 1] > \text{B}[j]A[i−1]>B[j] 
Means ii is too big, we must decrease it.
Thanks to @Quentin.chen for pointing out that: i<m⟹j>0i<m⟹j>0 and i>0⟹j<ni>0⟹j<n. Because:

m≤n, i<m⟹j=m+n+12−i>m+n+12−m≥2m+12−m≥0m≤n, i<m⟹j=m+n+12−i>m+n+12−m≥2m+12−m≥0

m≤n, i>0⟹j=m+n+12−i<m+n+12≤2n+12≤nm≤n, i>0⟹j=m+n+12−i<m+n+12≤2n+12≤n

So in situation 2. and 3. , we don't need to check whether j > 0j>0 and whether j < nj<n.