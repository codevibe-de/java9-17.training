package e_deprecated;

public class DeprecatedService {

    /**
     * @deprecated for performance reasons, use {@link #newMethod()} instead
     */
    @Deprecated(forRemoval = true, since = "2.0")
    public String foo() {
    	System.out.println("Calling foo()");
        return "";
    }

    /**
     * @deprecated for performance reasons, use {@link #newMethod()} instead
     */
    @Deprecated(forRemoval = false, since = "2.1")
    public String bar() {
    	System.out.println("Calling bar()");
        return "";
    }

    public String newMethod() {
        return "new";
    }

}
