package p_process;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"unused", "CommentedOutCode"})
public class ProcessApp {

    @Test
    void demoProcessHandle() {
        MethodLogger.logMethodCall();
        ProcessHandle handle = ProcessHandle.current();
        printProcessHandle(handle);
        ProcessHandle.Info info = handle.info();
        printProcessHandleInfo(info);
    }


    @Test
    void demoAllProcesses() {
        MethodLogger.logMethodCall();
        ProcessHandle.allProcesses()
                .filter(ProcessApp::filterJavaAndEclipse)
                .forEach(ProcessApp::printProcessHandle);
    }

    private static boolean filterJavaAndEclipse(ProcessHandle handle) {
        ProcessHandle.Info info = handle.info();
        Optional<String> command = info.command();
        return command.filter(s -> s.contains("java") || s.contains("eclipse")).isPresent();
    }


    @Test
    void oldExec() throws IOException {
        MethodLogger.logMethodCall();
         Runtime.getRuntime().exec(new String[] { "calc.exe" });
    }


    @Test
    void demoExec() throws Exception {
        MethodLogger.logMethodCall();
        Process process = new ProcessBuilder("calc.exe").start();
        ProcessHandle handle = process.toHandle();
        printProcessHandle(handle);

        ProcessHandle.Info info = process.info();
        printProcessHandleInfo(info);

        ProcessHandle
                .of(process.pid())
                .ifPresent(ProcessApp::printProcessHandle);
    }


    // does not work reliably
    // https://stackoverflow.com/questions/11350347/runtime-exec-waitfor-not-actually-waiting-for
    @Test
    void demoExecWaitFor() throws Exception {
        MethodLogger.logMethodCall();
        Process process = new ProcessBuilder("calc.exe").start();
        System.out.println(process);
        System.out.println("waiting...");
        int result = process.waitFor();
        System.out.println("Finished: " + result);
    }


    @Test
    void demoExecFuture() throws Exception {
        MethodLogger.logMethodCall();
        Process process = new ProcessBuilder("calc.exe").start();
        System.out.println(process);
        final CompletableFuture<Process> future = process.onExit();
        System.out.println("waiting...");
        Process p = future.get();
        System.out.println(p);
        System.out.println("Finished");
    }


    @Test
    void demoDestroy1() throws IOException, InterruptedException {
        MethodLogger.logMethodCall();
        Process process = new ProcessBuilder("calc.exe").start();
        Thread.sleep(500);
        process.destroy();
        Thread.sleep(500);
    }


    @Test
    void demoDestroy2() throws IOException, InterruptedException {
        MethodLogger.logMethodCall();
        Process process = new ProcessBuilder("calc.exe").start();
        Optional<ProcessHandle> handle = ProcessHandle.of(process.pid());
        Thread.sleep(500);
        handle.ifPresent(ph -> {
            boolean done = ph.destroy();
            System.out.println("Destroyed: " + done);
        });
        Thread.sleep(500);
    }


    private static void printProcessHandle(ProcessHandle handle) {
        System.out.println(handle.getClass().getSimpleName());
        System.out.println("\tpid              = " + handle.pid());
        System.out.println("\tisAlive          = " + handle.isAlive());
        System.out.println("\tparent           = " + handle.parent());
        System.out.println("\tchildren         = " + handle.children().toList());
        System.out.println("\tdescendants      = " + handle.descendants().toList());
        System.out.println("\tsupports...      = " + handle.supportsNormalTermination());
    }

    private static void printProcessHandleInfo(ProcessHandle.Info info) {
        System.out.println("ProcessHandle.Info");
        System.out.println("\tcommand          = " + info.command());
        System.out.println("\tcommandLine      = " + info.commandLine());
        System.out.println("\targuments        = " + info.arguments());
        System.out.println("\tstartInstant     = " + info.startInstant());
        System.out.println("\ttotalCpuDuration = " + info.totalCpuDuration());
        System.out.println("\tuser             = " + info.user());
    }
}
