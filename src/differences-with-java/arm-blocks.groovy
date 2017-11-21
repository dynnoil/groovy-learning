// ARM (Automatic Resource Management) block from Java 7 are not supported in Groovy.
// Instead, Groovy provides various methods relying on closures, which have the same
// effect while being more idiomatic. For example:

String path = './file'

// Path file = Paths.get(path);
// Charset charset = Charset.forName("UTF-8");
// try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
//     String line;
//     while ((line = reader.readLine()) != null) {
//         System.out.println(line);
//     }

// } catch (IOException e) {
//     e.printStackTrace();
// }

// can be written like this:

new File(path).eachLine('UTF-8') {
    println it
}

// or, if you want a version closer to Java:

new File(path).withReader('UTF-8') { reader -> 
    reader.eachLine {
        print it
    }
}