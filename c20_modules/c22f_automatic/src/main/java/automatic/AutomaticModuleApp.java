package automatic;

import mod_f.Foo;

public class AutomaticModuleApp {

    public static void main(String[] args) {
        new Foo().hello();
    }
}


// C:\Users\Aui\scoop\apps\openjdk\current\bin\java.exe
// "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.1\lib\idea_rt.jar=50607:C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.1\bin"
// -Dfile.encoding=UTF-8
// -Dsun.stdout.encoding=UTF-8
// -Dsun.stderr.encoding=UTF-8
// -classpath D:\Workspaces\Codevibe\java9-17.training\c20_modules\c22f_automatic\target\classes;D:\Workspaces\Codevibe\java9-17.training\c20_modules\c22f_foo\target\classes;C:\Users\Aui\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.10.0\junit-jupiter-api-5.10.0.jar;C:\Users\Aui\.m2\repository\org\opentest4j\opentest4j\1.3.0\opentest4j-1.3.0.jar;C:\Users\Aui\.m2\repository\org\junit\platform\junit-platform-commons\1.10.0\junit-platform-commons-1.10.0.jar;C:\Users\Aui\.m2\repository\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;C:\Users\Aui\.m2\repository\org\assertj\assertj-core\3.24.2\assertj-core-3.24.2.jar;C:\Users\Aui\.m2\repository\net\bytebuddy\byte-buddy\1.12.21\byte-buddy-1.12.21.jar automatic.AutomaticModuleApp
