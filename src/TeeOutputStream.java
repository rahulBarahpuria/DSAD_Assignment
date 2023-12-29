import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream extends OutputStream {

    private final OutputStream consoleOutputStream;
    private final OutputStream fileOutputStream;

    public TeeOutputStream(OutputStream consoleOutputStream, OutputStream fileOutputStream) {
        this.consoleOutputStream = consoleOutputStream;
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        consoleOutputStream.write(b);
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        consoleOutputStream.write(b);
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        consoleOutputStream.write(b, off, len);
        fileOutputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        consoleOutputStream.flush();
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        consoleOutputStream.close();
        fileOutputStream.close();
    }
}
