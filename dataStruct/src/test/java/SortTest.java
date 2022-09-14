import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
class Person implements Serializable{
    private String name;
    private Integer age;
}

public class SortTest {

    private Person person = new Person();

    private void test(List<byte[]> list) {
        for (int i = 0; i < 3; i++) {
            person.setName("name" + i);
            person.setAge(i);
            byte[] bytes = objectToBytes(person);
            list.add(bytes);
        }
    }

    public static byte[] objectToBytes(Object obj) {
        // logger.debug("objectToString called ");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream sOut = null;
        try {
            sOut = new ObjectOutputStream(out);
            sOut.writeObject(obj);
            sOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = out.toByteArray();
        return bytes;
    }

    public static Object bytesToObject(byte[] bytes) {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream sIn = null;
        try {
            sIn = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return sIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        new SortTest().test(list);
        list.forEach(x->System.out.println(bytesToObject(x)));
    }
}
