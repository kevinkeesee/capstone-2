Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation
* All of the values of the classes I created have private attributes, and said attributes can only be altered in logical ways.
For example, the health values can only be modified through an attack function that requires an int for the damage value, and the ascii classes can only be modified by selecting a file number.

* Even though I could have been better at it overall, I was able to reduce clutter in the Game Screen class by bundling relevent functions in their respective classes.

********************
2. Inheritance

* I made the Game Screen class inherit JPanel for responsive graphics, and implement KeyListener for input.

* I also made 2 interfaces, one for the ascii classes and another for the player and enemies.  It actually changed my perspective on them and made me change the functions to have the same inputs and outputs, and I think the program benefitted as a result.

********************
3. Abstraction

* Every screen requires a mere single button press while the program handles everything else and updates the visuals instantly.  If that isn't proper abstraction I don't know what is.

* Also I exported the entire project to a simple .jar executable less than 10kb in size, very simple and lightweight for end users.

********************
4. Polymorphism

* I don't think I was able to do much of that with the time I had, but one idea I came up with was changing the takeDamage function to alternatively accept an enemy class as a parameter, and use the getAttack function it contains instead of an int parameter.


Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  

* The concept of object oriented programming is important for scalability and readability.  Java class names and functions are known for being decriptive and literal, so a proper line of code in a sufficiently object-oriented program should nearly read like an English sentence.  And no matter what size or complexity the program scales to, the code can still remain just as readable.

* Encapsulation is one of the most noticeable attributes, because of how it simplifies code when many classes are intersecting and using their functions.
* Inheritance is useful for communicating with other developers, for example how both the Player and Enemy in my program belonged to the same class to highlight their similar roles in the context of the game world.
* Abstraction is useful for the end user, they don't need to know anything about the inner working just so long as they know what they need to know.  Abstraction in modern computing is the reason they're so accessible and widespread.
* Polymorphism ties into inheritance, and allows more flexibility and diversity.