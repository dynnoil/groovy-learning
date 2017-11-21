// Because Groovy uses Objects for everything, it autowraps
// references to primitives. Because of this, it does not follow
// Java’s behavior of widening taking priority over boxing.
// Here’s an example using int:

class PrimitivesAndWrappers {
    
    static void m(long l) { // this is the method that Java would call, since widening has precedence over unboxing
        println "in m(long)"
    }

    static void m(Integer i) { // this is the method Groovy actually calls, since all primitive references use their wrapper class
        println "in m(Integer)"
    }
}

int i
PrimitivesAndWrappers.m(i)
