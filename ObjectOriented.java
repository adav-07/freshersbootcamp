import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.ArrayList;

class StringListFilterItems{
    private String[] filteredItems;
    StartsWithStrategy strategyObject=new StartsWithStrategy();
    
    
    public void setFilterItems(String[] items){
        filteredItems = items;
    }
    
    public String[] filterItems() {
        strategyObject.setStartsWith("Z");
        ArrayList<String> tempList=new ArrayList<>();
        for (String item : filteredItems){
            if(strategyObject.invoke(item)){
                tempList.add(item);
            }
        }
        String[] returnList=new String[tempList.size()];
        for(int i=0;i<tempList.size();i++){
            returnList[i] = tempList.get(i);
        }
        return returnList;
    }
}

class StartsWithStrategy{
    
    private String startsWith;
    
    public void setStartsWith(String startString){
        startsWith=startString;
    }
    
    public boolean invoke(String item){
        return item.startsWith(startsWith);
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
        
        filterObject.setFilterItems(items);
        String[] itemsStartsWith = filterObject.filterItems();
        ConsoleDisplayController displayObject=new ConsoleDisplayController();
        displayObject.setContent(itemsStartsWith);
        displayObject.display();
    }
}
