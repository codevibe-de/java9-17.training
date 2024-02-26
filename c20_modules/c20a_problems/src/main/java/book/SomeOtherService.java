package book;

public class SomeOtherService {

    void accessToPackagePrivateInOtherLibrary() {
        // problem 2/5
        new DefaultBookService().somePackagePrivateMethod();
    }

}
