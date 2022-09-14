package exercise;

/**
 * 命令模式
 */
public class CommandDemo01 {

    private interface Command {
        void doIt();

        void unDoIt();
    }

    private static class Content {
        private String msg;

        public Content(String msg) {
            this.msg = msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    private static class ContentCommand implements Command {

        private Content content;

        private String something = "contentCommand";

        public ContentCommand(Content content) {
            this.content = content;
        }

        public void doIt() {
            content.setMsg(content.getMsg() + "contentCommand");
        }

        public void unDoIt() {
            content.setMsg(content.getMsg().substring(0, content.getMsg().length() - something.length()));
        }
    }


    public static void main(String[] args) {
        Content content = new Content("hello World");
        System.out.println(content.getMsg());

        ContentCommand contentCommand = new ContentCommand(content);
        contentCommand.doIt();
        System.out.println(content.getMsg());

        contentCommand.unDoIt();
        System.out.println(content.getMsg());
    }
}
