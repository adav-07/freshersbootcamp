import java.util.stream.Stream;
import java.util.function.Predicate;

class StringMethods{
    public String[] filterItems(String[] items, Predicate<String> criteria) {
      return Stream.of(items).filter(criteria)
              .toArray(String[]::new);
    }
    public Predicate<String> checkStringStartWithAny(String startString){
        Predicate<String> preciateFunctionObj =str -> str.startsWith(startString);
        return preciateFunctionObj;
    }
}

class Display{
    public void display(String [] itemsStartsWith){
        for(String item: itemsStartsWith){
            System.out.println(item);
        }
    }
}

class Main {
    public static void main(String[] args) {
        String[] items = {"hello","HI","WelComE","to","ZEISS"};
        StringMethods Stringobject=new StringMethods();
        String[] itemsStartsWith = Stringobject.filterItems(items, str -> str.startsWith("H"));
        Display displayObject=new Display();
        displayObject.display(itemsStartsWith);
    }
}
