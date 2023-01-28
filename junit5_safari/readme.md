
# Exception Test
## Use Functional Style
```java
@Test
void exception() {
  String str = null;
  assertThows(NullPointerException.class, 
       () -> {
          str.length();
       }
  );
}
```
# Performance Test
```java
@Test
void performaceTest(){
  assertTimeout(Duration.ofSeconds(5),
    () -> {
       testMethod();
    }
  );
}
```

# Display Name
```java
@Test
@DisplayName("When length is null, throw an exception")
public void exception_test(){
}
# Parameterized Test
```java
@ParameterizedTest
@ValueSource(strings={"ABCD", "ABD", "A"})
void length_greater_than_zero(String str) {
   assertTrue(str.length() > 0);
}
```
# Advanced Patameterized Test
```java
@ParameterizedTest
@CsvSource(value{"abcd, ABCD", "abc, ABC"})
void uppercase(String word, String capitalizedWord) {
  assertEquals(capicalizedWord, word.toUpperCase());
}
```
# Giving a name to a Parameterized Test
```java
@ParameterizedTest(name = "{0} toUpperCase is {1}")
@CsvSource(value{"abcd, ABCD", "abc, ABC"})
void uppercase(String word, String capitalizedWord) {
  assertEquals(capicalizedWord, word.toUpperCase());
}
```
# Repeat Test
```java
@Test
@RepeatedTest(10)
```

# Nested Test
```java
@Nested
class EmptyStringTests {
  @BeforeEach
  void setToEmpty() {
    str = "";
  }
  
  @Test
  void lengthIsZero() {
    assertEquals(0, str.length());
  }
  @Test
  void upperCaseIsEmpty(){
    assertEquals("", str.toUpperCase());
  }
}
```
