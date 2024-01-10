import java.util.stream.Stream;
import java.util.function.Predicate;

class StringListFilterItems{
    
    public String[] filterItems(String[] items, Predicate<String> criteria) {
      return Stream.of(items).filter(criteria)
              .toArray(String[]::new);
    }
}

class StartsWithStrategy{
    
    private String startsWith;
    
    public void setStartsWith(String startString){
        startsWith=startString;
    }
    
    public Predicate<String> checkStringStartWithAny(){
        Predicate<String> preciateFunctionObj =str -> str.startsWith(startsWith);
        return preciateFunctionObj;
    }
}

class ConsoleDisplayController{
    
    private String[] content;
    
    public void setContent(String [] itemsStartsWith){
        content = itemsStartsWith;
    }
    
    public void display(){
        for(String item : content){
            System.out.println(item);
        }
    }
}

class Main {
    public static void main(String[] args) {
        String[] items = {"hello","HI","WelComE","to","ZEISS"};
        StringListFilterItems filterObject=new StringListFilterItems();
        StartsWithStrategy strategyObject=new StartsWithStrategy();
        strategyObject.setStartsWith("Z");
        String[] itemsStartsWith = filterObject.filterItems(items, strategyObject.checkStringStartWithAny());
        ConsoleDisplayController displayObject=new ConsoleDisplayController();
        displayObject.setContent(itemsStartsWith);
        displayObject.display();
    }
}
