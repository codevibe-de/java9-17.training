package w_stackwalker;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Tracer implements AutoCloseable {
    private static final StackWalker walker = StackWalker.getInstance();
    private static int indent;
    private final String name;
    private Object value;

    /**
     * @param args Arguments passed to the method that is to be traced
     */
    public Tracer(Object... args) {
        StackWalker.StackFrame frame = walker.walk(s -> s
                .limit(2)
                .collect(Collectors.toList())
        ).get(1);
        this.name = frame.getClassName() + "." + frame.getMethodName();

        String argsStr = Arrays.stream(args)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        this.trace(">> " + name + "(" + argsStr + ")");
        indent++;
    }

    public void trace(String msg) {
        for (int i = 0; i < indent; i++) {
            System.out.print("\t");
        }
        System.out.println(msg);
    }

    public <T> T value(T value) {
        this.value = value;
        return value;
    }

    @Override
    public void close() {
        indent--;
        String s = this.value == null ? "" : " -> " + String.valueOf(this.value);
        this.trace("<< " + name + s);
    }
}