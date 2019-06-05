# Java Katas
This is a collection of katas I've collected from various user group meetups, books, videos, and conferences I've attended over time.  I have attributed the source as best as I can determine for these katas in their description.  

I am borrowing the structure of this repository from Dan Wiebe's [Scala_Katas](https://github.com/dnwiebe/Scala_Katas).  He describes the structure as follows:
>#### Note
> There are several branches in this repository:
>* ```master```: Contains skeleton tests and skeleton production code for 
 each of the katas listed here. All the tests fail. You can use the
 existing code and tests to build your solution on, or you can completely
 replace some or all of it.
>* all the others: Each kata has its own branch.  If you check out the
 branch for a particular kata, all the code for the other katas will
 disappear, and you'll see a possible solution for the selected kata.
 All the tests pass. In all cases, there are other solutions; there 
 may even be _better_ solutions.  The ones provided _are_ solutions, 
 but not _the_ solutions.  
 
### Triangles
From the Columbus Scala User Group's repo of [katas](https://github.com/dnwiebe/Scala_Katas) is a simple kata to determine different types of triangles.
>Using TDD, write a method or function that accepts three numbers as the lengths of three line segments.
 Determine computationally which of the following cases are true:
> 
>The three segments
>   1. Can be joined into an equilateral triangle. (example: 3, 3, 3)
>   1. Can be joined into an isosceles triangle. (example: 5, 5, 3);
>   1. Can be joined into a right triangle. (example: 3, 4, 5);
>   1. Can only be joined into a triangle that is not one of the preceding cases. (example: 2, 3, 4)
>   1. Cannot be made into a triangle. (example: 2, 3, 5) [Warning: might look isosceles at first glance.]
> 
> The order in which the segments are supplied must not affect the result.

### FizzBuzz
A timeless classic.  One of the origin stories for this kata is that it models a playground game where children took turns saying sequential numbers, but substituting the words Fizz and/or Buzz when the number was a multiple of 3 and/or 5.

This kata is a popular white boarding exercise, to a point where it is almost a white boarding cliche.  This kata is great for practicing small steps, writing the most basic code needed to make a unit test pass, and refactoring.

Here are the rules for this kata: 
 * Write a method that takes an integer and returns a string.  This represents the act of saying a number.
 * The string should be the numerical characters that represent the value of the integer that was passed, EXCEPT:
   * When the integer passed is a multiple of 3, the method should say Fizz.
   * When the integer passed is a multiple of 5, the method should say Buzz.

There are some variations that are good to implement once you have these basic rules implemented.
 * Implement a method that takes a lower boundary integer and a upper boundary integer and return a list of the spoken words from the integers inbetween those boundaries.
 * Practice changing requirements:
   * Change the number associated with Fizz to 4 or another value.
   * Add a third word, "BANG" for multiples of 11.
 * Implement restrictions on the method input, for example limit the integers to positive integers.
