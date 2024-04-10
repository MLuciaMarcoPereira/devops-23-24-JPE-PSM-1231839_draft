# Technical Report for Class Assignment 2 (Part 1) - Gradle Practice

## Introduction

This technical report marks the completion of Part 1 of Class Assignment 2 for the DevOps class, undertaken by Lucia Marco, student number 1231839, this report serves as a comprehensive
documentation of the steps followed, commands executed, and challenges encountered during the completion of the
assignment. Through detailed explanations and insights gained from hands-on exercises, this report aims to provide a
thorough understanding of the realm of Gradle Build Tool, a primary component in modern software development workflows.

Gradle is a build automation tool used primarily for building, testing, and deploying software projects. It automates the process of compiling source code, running tests, packaging the application, and deploying it to various environments.

In this tutorial, you will learn how to work with Gradle by completing various tasks on a simple example application. The goal of this tutorial is to help you understand how to use Gradle to build, test, and package your Java applications.

## Table of Contents

1. [Getting Started](#1-getting-started)
2. [Executing the Server](#2-executing-the-server)
3. [Adding a Unit Test](#3-adding-a-unit-test)
4. [Backing Up Source Files](#4-backing-up-source-files)
5. [Creating a Zip Archive](#5-creating-a-zip-archive)
6. [Completing the Assignment](#6-completing-the-assignment)
7. [Conclusion](#7-conclusion)


## 1. Getting Started

To begin, make sure you have Gradle installed on your system. If not, you can download and install it from [here](https://gradle.org/install/).

We will be using GitHub Issues feature to keep track of the tasks ahead.
Open a new issue on GitHub describing the task you are about to implement. Once the issue is open, note down its issue number.

1. Open a new issue on GitHub named "Adding gradle demo to CA2/Part1"

2. Next, clone the example application repository to your local machine, to a newly created package named CA2/Part1, using the following commands in your terminal:

   ```bash
   mkdir ../CA2/Part1
   cd ../CA2/Part1
   git clone https://bitbucket.org/pssmatos/gradle_basic_demo/
   ```

3. Add all files to the staging area:

   ```bash 
     git add .
   ```

4. Commit the added files and close the issue on GitHub by referencing the commit that resolves it in the issue comments:

   ```bash
   git commit -m "[feat] closes #<issue_number> - Added gradle demo to CA2/Part1"
   ```

5. Push the commit to the remote repository:

   ```bash
   git push
   ```

## 2. Executing the Server
In this part, we will add a task to our Gradle build script that allows us to run the chat server application. This task will simplify the process of starting the server, making it more convenient for developers.
By adding a dedicated task to start the server, developers can easily run the application without having to remember complex command-line arguments. This improves the developer experience and makes the project more user-friendly.

Follow these steps:

1. Open a new issue on GitHub named "Adding a task to run the server"

2. Navigate to the project directory and set up our workspace:

   ```bash
   cd gradle_basic_demo
   ```

   *Important*: Close the project before opening it in the root/package of the new project!

3. Open the build.gradle file located in the root of the project using your preferred text editor.

4. Scroll to the end of the file and add the following task:

   ```gradle
   task runServer(type: JavaExec, dependsOn: classes) {
       group = "DevOps"
       description = "Launches a chat server that listens on localhost:59001"
   
       classpath = sourceSets.main.runtimeClasspath
   
       mainClass = 'basic_demo.ChatServerApp'
   
       args '59001'
   }
   ```

5. Save the build.gradle file.

6. Compile the project using the following command:

   ```bash
   ./gradlew build
   ```

   Alternatively, you can run the newly added task independently by executing:

   ```bash
   ./gradlew runServer
   ```

7. Commit the changes:

   ```bash
   git add .
   git commit -m "[feat] closes #<issue_number> - Add runServer task."
   git push
   ```

## 3. Adding a Unit Test
Here, we'll create a test class and write a unit test for our application. Unit tests are small, targeted tests that verify the behaviour of individual components of our code.
Unit tests help ensure that our code behaves as expected and catches bugs early in the development process. By writing tests, we can increase the reliability and maintainability of our codebase.

Follow these steps:

1. Open a new issue on GitHub named "Creating a new server test file"

2. Create a new test folder using the following command:

   ```bash
   mkdir -p src/test/java/basic_demo
   ```

3. Create a new test class file using the following command:

   ```bash
   touch src/test/java/basic_demo/ChatServerAppTest.java
   ```

4. Open the ChatServerAppTest class:

   ```java
   package basic_demo;
   
   import org.junit.Test;
   import static org.junit.Assert.*;
   public class ChatServerAppTest {
   }
   ```

5. Add the following unit test:

   ```java
       @Test 
       public void testAppHasAGreeting() {
           ChatServerApp classUnderTest = new ChatServerApp();
           assertNotNull("app should have a greeting", classUnderTest.getGreeting());
       }
   ```

6. Save the ChatServerAppTest.java file.

7. Add the JUnit dependency to the build.gradle file:

   ```gradle
   dependencies {
    // Use Apache Log4J for logging implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2' implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2' testImplementation 'junit:junit:4.12'
    }
   ```

   *Note*: The  unit  tests  require  junit  4.12  to  execute.

8. Navigate to the project folder and compile the project again in the terminal, using:

   ```bash
   ./gradlew build
   ```

   Alternatively, you can run the task independently by executing the following command:

   ```bash  
   ./gradlew runServer
   ```

9. Add and commit the changes:

   ```bash
   git add .
   git commit -m "[feat] closes #<issue_number> - Added new server test file."
   git push
   ```

## 4. Backing Up Source Files
In this step, we'll create a task to make a backup of our application's source files. This task will copy the source files to a backup directory, providing an additional layer of protection for our code.
Creating regular backups of our code is essential for disaster recovery and version control. By automating the backup process with a Gradle task, we ensure that our code is safely stored and can be restored if needed.

1. Open a new issue on GitHub named "Create backup for source files"

2. Open the build.gradle file again. Add the following task definition:

   ```gradle
   
   task copySources(type: Copy) {
       group = "DevOps"
       description = "Copy source files to the target directory"
   
       from 'src/'
       into 'backup/'
   }
   ```

3. Save the build.gradle file.

4. Compile the project:

   ```bash
   ./gradlew build
   ```

   Alternatively, you can also execute the task independently using the command:

   ```bash  
   ./gradlew copySources
   ```

5. Commit your changes:

   ```bash
   git add .
   git commit -m "[feat] closes #<issue_number> - Added backup to source files."
   git push
   ```

## 5. Creating a Zip Archive
Finally, we'll create a task to create a zip archive of our application's source files. This task will package the source code into a single zip file, making it easier to distribute and share the code with others.
Zip archives are a common way to package and distribute code or files. By creating a zip archive of our source code, we can easily share it with collaborators or deploy it to other environments.

Follow these steps:

1. Open a new issue on GitHub named "Create zip file for source code"

2. Open the build.gradle file. Add the following task definition:

   ```gradle
   task zipSources(type: Zip) {
       group = "DevOps"
       description = "Zip source files to the target directory"
   
       from 'src/'
       archiveFileName = 'src.zip'
       destinationDir = file('backup/')
   }
   ```

3. Save the build.gradle file.

4. Compile the project:

   ```bash
   ./gradlew build
   ```

   Alternatively, you can also execute the task independently using this command:

   ```bash  
   ./gradlew zipSources
   ```

5. Add and commit your changes (do not push):

   ```bash
   git add .
   git commit -m "[feat] closes #<issue_number> - Added zip file for source code."
   ```

## 6. Completing the Assignment

You have now successfully completed Part 1 of Class Assignment 2. To close the assignment, follow these steps:

1. Create a new tag to mark the completion of this part:

   ```bash
   git tag ca2-part1
   ```

2. Finally, push the committed changes and the new tag to the remote repository on GitHub.

   ```bash
   git push origin --tags
   ```

## 7. Conclusion

The completion of Part 1 of Class Assignment 2 marks a significant milestone in the journey into the world of Gradle Build Tool. Through practical exploration and meticulous documentation, invaluable insights and hands-on experience have been gained in harnessing Gradle's capabilities for efficient project management.

From understanding dependency management to optimizing project workflows through task automation, Gradle has proven to be a powerful ally in streamlining development processes. The documentation provided in this report serves as a comprehensive resource, offering guidance for future projects and endeavors.

Reflecting on the challenges overcome and lessons learned, it's evident that continuous practice and exploration are essential for fully leveraging Gradle's potential in real-world scenarios. As the journey in DevOps continues, the knowledge and skills gained from this assignment will undoubtedly serve as a solid foundation for future projects and collaborations in software development.


[Back to top](#Table-of-Contents)