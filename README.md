# police-target-map
Code Exercise - matrix movement

In this exercise you are given a map as a string. This map is a grid, with rows separated by ";".
It may contain the following:
- "_": empty
- "O": officer
- "T": Target
- "X": obstacle that the officer cant traverse

The solution is to create a function that when invoked it gives you the quickest possible route for the
officer to the target (counting the Officer and the target). If there is no Officer or Target on the map
it should return -2;

Example:

map: "O__;X__; _ T _"
as a matrix : 
[O _ _]
[X _ _]
[_ T _]

The quickest route could be right, down, down, so counting the start, the answer should be 4. Note the officer can't 
go Down on their first movement due to the obstacle.

if no Possible solution exist it should return -1.
