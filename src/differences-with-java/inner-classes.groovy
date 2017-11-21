// The implementation of anonymous inner classes and nested classes
// follows the Java lead, but you should not take out the Java Language Spec
// and keep shaking the head about things that are different. The implementation
// done looks much like what we do for groovy.lang.Closure, with some benefits
// and some differences. Accessing private fields and methods for example can
// become a problem, but on the other hand local variables don’t have to be final.

//
// 1. Static Inner Classes
//

class A {
    static class B {}
}

new A.B()

// The usage of static inner classes is the best supported one.
// If you absolutely need an inner class, you should make it a static one.

//
// 2. Anonymous Inner Classes
//

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

CountDownLatch called = new CountDownLatch(1)

Timer timer = new Timer()
timer.schedule(new TimerTask() {
    void run() {
        called.countDown()
    }
}, 0)

assert called.await(10, TimeUnit.SECONDS)

//
// 3. Creating Instances of Non-Static Inner Classes
//

// In Java you do:

// public class Y {
//     public class X {}
//     public X foo() {
//         return new X();
//     }
//     public static X createX(Y y) {
//         return y.new X();
//     }
// }

// Groovy doesn’t support the y.new X() syntax.
// Instead, you have to write new X(y), like in the code below:

public class Y {
    public class X {}
    public X foo() {
        return new X()
    }
    public static X createX(Y y) {
        return new X(y)
    }
}

// Caution though, Groovy supports calling methods with one parameter
// without giving an argument. The parameter will then have the value null.
// Basically the same rules apply to calling a constructor. There is a danger
// that you will write new X() instead of new X(this) for example. Since this 
// might also be the regular way we have not yet found a good way to prevent this problem.