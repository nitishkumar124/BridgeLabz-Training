package reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author{
	String name();
}

@Author(name = "Ram Charan")
class Book{
}
public class RuntimeAnnotation {
	public static void main(String[] args) {
		Class<Book> cls = Book.class;
		
		if(cls.isAnnotationPresent(Author.class)) {
			Author author = cls.getAnnotation(Author.class);
			System.out.println("Author Name: " + author.name());
		}
	}
}
