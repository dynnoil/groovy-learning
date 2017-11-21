// In Java == means equality of primitive types or identity for objects.
// In Groovy == translates to a.compareTo(b)==0, if they are Comparable,
// and a.equals(b) otherwise. To check for identity, there is is. E.g. a.is(b).

class Foo {
    int number = 2

    boolean equals(Foo f) {
        return f.number == number
    }
}

Foo f1 = new Foo()
Foo f2 = new Foo()

assert f1 == f2
assert !f1.is(f2)