package it.corsojava;

import it.corsojava.datasources.StringDataSources;
import it.corsojava.insiemi.Comune;
import it.corsojava.insiemi.Comuni;

import java.util.List;

public class MethodRefedenceTest {

    public static void main(String[] args) {
        Comuni archivio=new Comuni();
        archivio.load(StringDataSources.getComuni());
        List<Comune> comuni = archivio.getAll();
        // ------------------------------------------------------------------------------

        // ===============================================================================
        // METHOD REFERENCE
        // ===============================================================================

        // STATIC METHOD =================================================================

        // Consumer<String> fx = a -> System.out.println(a);
        // Consumer<String> fx = System.out::println;
        // fx.accept("Ciao");

        // Stream<String> frase = Stream.of("Lorem","ipsum","dolor","sit","amet,","consectetur","adipiscing","elit.");
        // frase.forEach(System.out::println);


        // CONSTRUCTOR ===================================================================

        // Supplier<Comune> fy = () -> new Comune();
        // Supplier<Comune> fy = Comune::new;
        // fy.get();

        // ---> per il prossimo esempio vedere classe SomeObject in fondo a questa unità di compilazione

        // Stream<String> frase = Stream.of("Lorem","ipsum","dolor","sit","amet,","consectetur","adipiscing","elit.");
        // List<SomeObject> objects = frase.map(SomeObject::new).collect(Collectors.toList());

        // INSTANCE METHOD ===============================================================

        // BiFunction<String,String, Integer> fff = (a,b) -> a.compareToIgnoreCase(b);
        // BiFunction<String,String, Integer> fff = String::compareToIgnoreCase;
        // int val=fff.apply("Buon","Giorno");

        // comuni.stream().map(Comune::getCodice).forEach(System.out::println);

        // OTHER OBJET INSTANCE METHOD ====================================================

        // ---> per questi esempi vedere classe Decorator in fondo a questa unità di compilazione

        // Stream<String> frase = Stream.of("Lorem","ipsum","dolor","sit","amet,","consectetur","adipiscing","elit.");
        // Decorator deco= new Decorator();
        // frase.map(deco::getDecoratedString).forEach(System.out::println);

        // Decorator deco = new Decorator("- ","|");
        // comuni.stream().map(Comune::getCodice).map(deco::getDecoratedString).forEach(System.out::println);

    }
}
class Decorator{

    private String before;
    private String after;

    public Decorator(){
        before="";
        after="";
    }

    public Decorator(String before, String after) {
        this();
        this.before = before;
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getDecoratedString(String s){
        return (before !=null ? before : "") + s + (after!= null ? after : "");
    }

}

class SomeObject{

    public SomeObject(String s){
    }

}