package e_deprecated;

public class DeprecatedService {

    /**
     * @deprecated Deprecated for performance reasons, use {@link #newMethod()} instead
     */
    @Deprecated(forRemoval = true, since = "2.0")
    public String foo() {
        return "";
    }

    /**
     * @deprecated Deprecated for performance reasons, use {@link #newMethod()} instead
     */
    @Deprecated(forRemoval = false, since = "2.1")
    public String bar() {
        return "";
    }

    public String newMethod() {
        return "new";
    }

}
