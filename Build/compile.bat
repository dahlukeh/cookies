cd ..\
"%JAVA_HOME%\javac" -verbose -d obj -classpath obj;"C:\libs\hamcrest-core-1.3.jar";"C:\libs\junit-4.11.jar" -sourcepath src src\andrew\cookies\*.java src\andrew\cookies\game\*.java
cd Build