### Exercise 2
 For the most part, the implementation I used was from [Javapapers.com](http://javapapers.com/core-java/java-iterator/).
 All I needed to change for making "every second item only" work was to change the `next()` method of the Iterator class like this:
 
```java    
 @Override
    public Object next() {
        Object aniObj = animal.get(position);
        position+= 2;
        return aniObj;
    }
```