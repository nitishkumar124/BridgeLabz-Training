package annotations;
import java.util.ArrayList;

public class SuppressUncheckedWarning {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        @SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList();

        list.add("Java");
        list.add(10);
        list.add(2.5);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
