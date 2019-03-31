package analyse.numerique.utils;

import static java.lang.System.currentTimeMillis;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

/**
 * @author CHRV
 */
public class LoggingExtension
        implements BeforeAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback, AfterAllCallback {

    private static final Namespace NAMESPACE = Namespace.create("extention", "LoggingExtension");
    private static final String REPORT_TEMPLATE = "---;{testcase};{method};{start};{end};{duration};{result};{error};{start};---;"
            + System.getProperty("line.separator");
    private FileWriter logFile;
    private int success;
    private int error;

    @Override
    public void beforeAll(ExtensionContext context) throws IOException {
        logFile = new FileWriter("log.txt", true);
        System.out.println(logFile);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        Store store = extracted(context);
        store.put(TemplateString.START, currentTimeMillis());
        store.put(TemplateString.TESTCASE, context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws IOException {
        long endTime = currentTimeMillis();
        Store store = extracted(context);
        if (context.getExecutionException().isPresent()) {
            store.put(TemplateString.DURATION, Long.valueOf(-1));
            store.put(TemplateString.END, Long.valueOf(-1));
            String message = context.getExecutionException().get().getMessage();
            store.put(TemplateString.ERROR, message == null ? "---" : message);
            store.put(TemplateString.RESULT, Boolean.FALSE);
            error++;
        } else {
            Long startTime = store.get(TemplateString.START, Long.class);
            store.put(TemplateString.DURATION, endTime - startTime);
            store.put(TemplateString.END, endTime);
            store.put(TemplateString.ERROR, "---");
            store.put(TemplateString.RESULT, Boolean.TRUE);
            success++;
        }
        report(context);
    }

    @Override
    public void afterAll(ExtensionContext context) throws IOException {
        logFile.write("SUCCESS = " + success + ";ERROR = " + error + ";RATIO = " + 100.0 * success / (error + success)
                + System.getProperty("line.separator"));
        logFile.flush();
        logFile.close();
    }

    public String get(ExtensionContext context, TemplateString key) {
        return extracted(context).get(key, String.class);
    }

    private void report(ExtensionContext context) throws IOException {
        Store store = extracted(context);
        String message = REPORT_TEMPLATE.replace("{start}", store.get(TemplateString.START, Long.class).toString())
                .replace("{end}", store.get(TemplateString.END, Long.class).toString())
                .replace("{duration}", store.get(TemplateString.DURATION, Long.class).toString())
                .replace("{result}", store.get(TemplateString.RESULT, Boolean.class).toString())
                .replace("{testcase}", store.get(TemplateString.TESTCASE, String.class))
                .replace("{error}", store.get(TemplateString.ERROR, String.class));
        context.publishReportEntry("logging", message);
        logFile.write(message);
        logFile.flush();
    }

    private Store extracted(ExtensionContext context) {
        return context.getStore(NAMESPACE);
    }

    private enum TemplateString {
        START, END, ERROR, DURATION, TESTCASE, RESULT
    }
}
