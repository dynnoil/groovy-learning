// Singly-quoted literals in Groovy are used for String,
// and double-quoted result in String or GString, depending
// whether there is interpolation in the literal.

assert 'c'.getClass() == String
assert "C".getClass() == String
assert "c${1}".getClass() in GString

// Groovy will automatically cast a single-character String to char
// only when assigning to a variable of type char. When calling methods
// with arguments of type char we need to either cast explicitly or
// make sure the value has been cast in advance.

char a = 'a'
assert Character.digit(a, 16) == 10 : 'But Groovy does boxing'
assert Character.digit((char) 'a', 16) == 10

try {
  assert Character.digit('a', 16) == 10 : 'Need explicit cast'
} catch(MissingMethodException e) {
    println e.getMessage()
}

// Groovy supports two styles of casting and in the case of casting to char
// there are subtle differences when casting a multi-char strings. The Groovy
// style cast is more lenient and will take the first character, while the C-style
// cast will fail with exception.

// for single char strings, both are the same
assert ((char) "c").class == Character
assert ("c" as char).class == Character

// for multi char strings they are not
try {
  ((char) 'cx') == 'c'
  assert false: 'will fail - not castable'
} catch(Exception e) {
    println e.getMessage()
}
assert ('cx' as char) == 'c'
assert 'cx'.asType(char) == 'c'