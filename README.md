# Java Functional - Fluid
## Do more by adding functional paradigm to your days with java.

Select one option to start:<br>[[Get start]](#getStarted) [[Next improvements]](#nextImprovements) [[Release Notes]](#releaseNotes)

### <a name="getStarted"></a>Get started
To start with the functional, you should download the project from git repository in the main branch, generate a jar and add it to your projectin order to be able to work with the functional library.
<ol>
 <li>Open the terminal and run the following command:
 
    git clone https://github.com/master-code-java/java-functional.git
 </li>
 <li>Get in the folder java-functional and run the following command: 
    
    mvn clean install
</li>
<li>Add the jar to your project:
    
    <dependency>
        <groupId>com.mastercode</groupId>
	    <artifactId>javaFunctional</artifactId>
	    <version>1.0.0</version>
	</dependency>
</li>
<li>Make a test.
Create a class with a main method and add the followig code to the main method and run it.
    
    sh
    Functional.of(new Object())
    .run(System.out::println);

if console show something like "java.lang.Object@cb51256" it's working.
</li>
</ol>

### <a name="nextImprovements"></a>Next improvements:
The next action that will be taken in the project, feel free to contribute with that.

- Create examples as well documentation.
- Create zip function which return a pair of two functions.
- Create suspend function which allows run block of code in a different thread.
- Create a extension function which allow to add functions to a type, this is, to add a block of code to a specifcally type.

### <a name="releaseNotes"></a>Release notes:
Here you can follow the last chage made in the library.

- 1.0.0 - Initial version - 2022, jun - 07.

Thanks Thiago!


<br>
