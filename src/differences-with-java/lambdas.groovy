// Java 8 supports lambdas and method references:

// Runnable run = () -> System.out.println("Run");
// list.forEach(System.out::println);

// Java 8 lambdas can be more or less considered as anonymous
// inner classes. Groovy doesn’t support that syntax, but has closures instead:

Runnable run = { println 'run' }

int[] list = [1, 2, 3, 4]

list.each { println it } // or list.each(this.&println)
list.each(this.&print)