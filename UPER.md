<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>

* The basic requirements include making an ascii game in a java terminal, with the goal of demonstrating object oriented design.
* I knew I had to research these concepts myself to be able to write any of it.
* I decided to settle on a dungeon crawler type of game, and originally wanted to replicate the first area in Demon's Souls.

<h2>
    2. Planning the Solution
</h2>

* I knew that I needed a system to display an ascii graphic that could update properly, and flavor text to go along with it.
* I wanted a responsive gui that could display health bars and the cumulative number of "points" from enemies.
* I eventually decided to try a first person perspective instead of top-down, to allow for more detail yet simplicity in design.
* I knew I had to make the player a class, and enemies as well.
* I decided to make a Reference class to store variables to keep the Game Screen class less cluttered.

<h2>
    3. Executing the Plan
</h2>

* After I had to restart my project, I tried to catch up by making the terminal and JFrame setup similar to before because it worked just fine for me.
* I started by drawing the gui in paintComponent and testing values in it.
* I then worked on getting a title screen to work by importing a .txt file, and did the same for basic flavor text.
* I worked on using the keyPressed funtion to advance past the title screen into another graphic.
* Once I had the player and enemy classes created I found a way to link a graphic with the existence of the Dregling class with boolean flags.
* I made sure to create a tutorial for combat that always occurs at the start.
* I finally made sure to implement a death screen that loops back to the title screen.
* I then exported the project to a runnable .jar file.

<h2>
    4. Reflection / Refactor
</h2>

* There are many things I would have liked to implement if I wasn't short on time but I'm mostly happy that it just works correctly and didn't give me many errors.
* One thing I wanted was sound effects for attacking and parrying and all that.
* Another big thing I wanted was a resizeable window, I could have used math to change all the hardcoded numbers into fractions of the current width and height.
* I also wanted the possibility of multiple enemy types and randomized branching hallways and treasure chests with items.
* Overall it may not be much, but it could function as the base for a much larger and better project, especially thanks to the object oriented design.