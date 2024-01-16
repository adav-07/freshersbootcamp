class WordDocument {
    DocumentPart[] documentParts;
    IConverter converter;
    WordDocument(DocumentPart[] documentParts, IConverter converter){
        this.documentParts = documentParts;
        this.converter = converter;
    }
    public boolean open(String path) {
        for(DocumentPart part: documentParts){
            part.paint();
        }
        return true;
    }
    public void convertToHTML(){
        for(DocumentPart part: documentParts){
            part.convert(converter);
        }
    }
}

interface IConverter {
    public void convert(Header header);
    public void convert(Footer footer);
    public void convert(Paragraph paragraph);
    public void convert(Hyperlink hyperlink);
}

class HTMLConverter implements IConverter {
    public void convert(Header header){
        System.out.println("Converting header to html");
    }
    
    public void convert(Footer footer){
        System.out.println("Converting footer to html");
    }
    
    public void convert(Paragraph paragraph){
        System.out.println("Converting paragraph to html");
    }
    
    public void convert(Hyperlink hyperlink){
        System.out.println("Converting hyperlink to html");
    }
}

abstract class DocumentPart {
    String name;
    Integer[] coordinates;
    abstract void paint();
    abstract void convert(IConverter converter);
}

class Paragraph extends DocumentPart {
    void paint(){
        System.out.println("Painting paragraph");
    }
    public void convert(IConverter converter){
        converter.convert(this);
    }
}

class Hyperlink extends DocumentPart{
    void paint(){
        System.out.println("Painting hyperlink");
    }
     public void convert(IConverter converter){
        converter.convert(this);
    }
}

class Header extends DocumentPart {
    void paint(){
        System.out.println("Painting Header");
    }
    public void convert(IConverter converter){
        converter.convert(this);
    }
}

class Footer extends DocumentPart {
    void paint(){
        System.out.println("Painting Footer");
    }
    public void convert(IConverter converter){
        converter.convert(this);
    }
}

public class Main{
    public static void main(String args[]) {
        
        DocumentPart paragraph = new Paragraph();
        DocumentPart hyperlink = new Hyperlink();
        DocumentPart header = new Header();
        DocumentPart footer = new Footer();
        DocumentPart[] parts = new DocumentPart[]{paragraph, hyperlink, header, footer};
        WordDocument wordDoc = new WordDocument(parts, new HTMLConverter());
        wordDoc.convertToHTML();
    
    }
}
