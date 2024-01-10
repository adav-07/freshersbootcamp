import java.util.stream.Stream;
import java.util.function.Predicate;

class StringListFilterItems{
    private String[] filteredItems;
    private Predicate<String> filterCriteria;
    
    public void setFilterItems(String[] items, Predicate<String> criteria){
        filteredItems = items;
        filterCriteria = criteria;
    }
    
    public String[] filterItems() {
      return Stream.of(filteredItems).filter(filterCriteria)
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

class HelloWorld {
    public static void main(String[] args) {
        String[] items = {"hello","HI","WelComE","to","ZEISS"};
        StringListFilterItems filterObject=new StringListFilterItems();
        StartsWithStrategy strategyObject=new StartsWithStrategy();
        strategyObject.setStartsWith("Z");
        filterObject.setFilterItems(items, strategyObject.checkStringStartWithAny());
        String[] itemsStartsWith = filterObject.filterItems();
        ConsoleDisplayController displayObject=new ConsoleDisplayController();
        displayObject.setContent(itemsStartsWith);
        displayObject.display();
    }
}
