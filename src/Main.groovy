// def process = "ls -lah".execute()
// process.in.eachLine { line -> 
//     println line
// }
import com.github.dynnoil.groovy.Person as Dude;

class Main {

    static void main(String... args) {
        Dude dude = new Dude('Vasilij', 12)
        
        assert dude.name == 'Vasilij'
        assert dude.age == 12
    }
}