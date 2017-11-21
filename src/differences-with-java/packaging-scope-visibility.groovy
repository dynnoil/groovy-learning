// In Groovy, omitting a modifier on a field doesn’t result in 
// a package-private field like in Java:

class Person {
    String name    
}

Person p = new Person();
p.name = "Leo"
println p.name

// Instead, it is used to create a property, that is to say 
// a private field, an associated getter and an associated setter.

// It is possible to create a package-private field by annotating it with @PackageScope:

import groovy.transform.PackageScope

class Employee extends Person {
    @PackageScope int age
}
