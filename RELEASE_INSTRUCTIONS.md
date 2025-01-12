#Release instructions

Compile the source code from the src directory into the bin directory. Include the junit and hamcrest libraries

## Script for MacOS - Linux

``` bash
rm -rf bin/*.class release.jar

javac -d bin -sourcepath src -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/**/*.java

jar cfm release.jar manifest.txt -C bin . -C public .
```

## Script for Windows
``` powershell
del /S /Q bin\*.class
del release.jar

javac -d bin -sourcepath src -cp lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar src\**\*.java

jar cfm release.jar manifest.txt -C bin . -C public .
```

# To run relase build
``` bash
java -jar release.jar
```