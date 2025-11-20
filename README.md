## 📄 Description - Exercise Statement

This is the fifth task for **Sprint 1 Java Language** in the **Backend Java Course** in ITAcademy (Barcelona, Spain).
There are 3 levels with exercises.

## Level 1

### Exercise 1

Create a class that lists the contents of a given directory alphabetically.

### Exercise 2

Add to the class from the previous exercise the functionality to list a directory tree with the contents of all its levels (recursively), ensuring that they are printed on screen in alphabetical order within each level, indicating whether it is a directory (D) or a file (F), and its last modification date.

### Exercise 3

Modify the previous exercise. Now, instead of displaying the result on the screen, save the result in a TXT file.

### Exercise 4

Add the functionality to read any TXT file and display its content on the console.

### Exercise 5

Now the program must serialize a Java Object to a .ser file and then deserialize it.

## Level 2

### Exercise 1

Execute exercise 3 from the previous level by parameterizing all methods in a configuration file.

You can use a Java Properties file, or the Apache Commons Configuration library if you prefer.

From the previous exercise, parameterize the following:

-   Directory to read.
-   Name and directory of the resulting TXT file.

## 📋 Requirements

Developed with:
- *IDE* : IntelliJ IDEA 2025.2.4 (Community Edition)
- *Java version* : openjdk 21.0.8 2025-07-15

## 🛠️ Installation

Fork or download this repo.

## ▶️ Execution

Tested with **Ubuntu 24.04.3 LTS**.


### Level 1 - Exercises 1 to 4

Tested with:
- *IDE* : IntelliJ IDEA 2025.2.4 (Community Edition)
- *Java version* : openjdk 21.0.8 2025-07-15

Put *path name* as **Program Argument** in *IntelliJ* runnig process select the option **Run with paramaters..** and put the input argument on **Program arguments'** cell.

### Level 1 - Exercise 3

When run *Level 1/Exercise 3* with *IntelliJ* the output file `directoriesInfo.txt` will be located on main folder where you commit this task.

### Level 1 - Exercise 4

Use absolute path for the *TXT* file To run the program with *IntelliJ* with the option **Run with paramaters**

For example, on Linux or Mac, `/home/user/documents/file.txt` is an absolute path, while on Windows, it might be `C:\Users\user\Documents\file.txt`

### Level 1 - Exercise 5

This exercise must be executed on terminal. Follow those steps :

1. Go to `level1ex5` folder : `cd src/level1ex5`
2. `javac *.java` for compile on console. 
3. `cd ..`
4. `java level1ex5.SerializerTestInJava` for run the program.

### Level 2 - Exercise 1

This exercise must be executed on terminal. Follow those steps :

1. Go to `level2ex1` folder : `cd src/level2ex1`
2. `javac *.java` for compile on console. 
3. `cd ..`
4. `java level2ex1.Main` for run the program.


