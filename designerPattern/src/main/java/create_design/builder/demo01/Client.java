package create_design.builder.demo01;

public class Client {
    public static void main(String[] args) {
        AbstractHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
