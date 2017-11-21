// In Groovy, the methods which will be invoked are chosen at runtime.
// This is called runtime dispatch or multi-methods. It means that the
// method will be chosen based on the types of the arguments at runtime.
// In Java, this is the opposite: methods are chosen at compile time,
// based on the declared types.

class MultiMethods {
    int method(String arg) {
        return 1;
    }

    int method(Object arg) {
        return 2;
    }
}

MultiMethods mm = new MultiMethods();
Object o = "object";
int result = mm.method(o);

assert result == 1;
println result;

// That is because Java will use the static information type, which is that
// o is declared as an Object, whereas Groovy will choose at runtime, when
// the method is actually called. Since it is called with a String, then the
// String version is called.
