# Recursive Job

This is an example of the recursive to find the hours during the job given an Id.

# Files

To execute the test you need to create the file following this structure.
<br />1,30,2,3
<br />2,10
<br />3,10

When:
<br />line one 1 (id), 30 (time), 2 and 3 (child)
<br />line two 2 (id) and 10 (time)
<br />line three 3 (id) and 10 (time)

When you execute these values, the sample application will return 40.

# Java version

1.8

# Execution

Clone the repository and execute these commands

````
mvn clean install
java -jar target/recursivejob-0.0.1-SNAPSHOT.jar "1" "filePath"
````
<br />The arg[0] represents which the job you will start
<br />The arg[1] represents the file path to get the values to create the object   

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update the tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
