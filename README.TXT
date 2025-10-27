Project: automaton
Aothors: David J. Barnes and Michael Kölling

This project is part of the material of the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

It is discussed in chapter 7.

part iii:
q27. yes, its still a serpinksi triangle
q28. it sets all of the cells back to a "off" position
q29. the patterns are completely differnet but yes, they are deterministic
q31. because without a pre making the next state, were changing the state as we go, which means we arent properly getting each of the new states, resulting in just a diagonal moving to the left

q32. i cant figure out how to write it myself, but im pretty sure it would involve storing the value of the left, centre, and right cells of the current cell before modifying it. personally i prefer the way which uses a  a next state and a current state array, as i find it easier to manipulate, but im pretty sure the other method would be more efficient
q35. there are likely an infinite or at least near-infinte number of wasy of combining them, but i think at a certain point they end up repeating previous ones, for example the last one i tried was centre + right*left + 1 + centre*right + left*centre*right, adding any odd number instead of one would result in the same thing, but would technically be a different calculation, same goes for a couple equations i tried that didnt use constants
