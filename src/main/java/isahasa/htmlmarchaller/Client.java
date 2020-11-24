package isahasa.htmlmarchaller;

public class Client {
    private Channel chanel;
    private TextSource textSource;

    public Client(Channel chanel) {
        this.chanel = chanel;
    }

    public int writeToChannel(TextSource textSource) {
        return chanel.writeByte(textSource.getPlainText().getBytes());
    }
}
