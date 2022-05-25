# Tuples [![Build Status](https://ci.josephworks.net/job/Tuples/badge/icon?style=flat-square)](https://ci.josephworks.net/job/Tuples/)

### A helper for storing multiple datatypes under a Tuple.

## Usage

You can use this library in your project by adding the following dependency to your project.
The latest version can be found on the GitHub Releases tab or Repository Server:

http://repo.josephworks.net/#browse/search=keyword%3Dtuples

### As Dependency
#### Maven Project

```xml
<repositories>
    <repository>
        <name>JosephWorks-Public</name>
        <id>josephworks-public</id>
        <url>https://repo.josephworks.net/repository/maven-public</url>
    </repository>
</repositories>

<dependency>
  <groupId>dev.cedo</groupId>
  <artifactId>Tuples</artifactId>
  <version>VERSION</version>
</dependency>
```

#### Gradle Project

```groovy
repositories {
    maven { url "https://repo.josephworks.net/repository/maven-public" }
}

implementation 'dev.cedo:Tuples:VERSION@jar'
```

### In Code
By default all Tuples are immutable unless you specify a mutable tuple
#### Creating new Tuples
```java
Pair<Integer, Integer> pair = Pair.of(20, 0);
//Mutable Tuple
MutableTriplet<Integer, Boolean, String> triplet = MutableTriplet.of(20, false, "cedo");
```
#### Modifying and using Tuple data
```java
// This allows for usage of the Tuple data
pair.use((a, b) -> System.out.println("First Value: " + a + ", Second Value: " + b));

//This will return a String of "cedo - 20 - false"
String data = triplet.apply((a, b, c) -> String.format("%s - %d - %b", c, a, b));

//For mutable tuples you can modify the values of tuples by doing the following:
        
//This will change the value of the second datatype to true
triplet.computeSecond(i -> !i);

//This will add 1 to the value of 20
triplet.computeFirst(i -> i + 1);

//This will add " is epic" to the end of the String so that it results in "cedo is epic"
triplet.computeThird(i -> i + " is epic");
```
