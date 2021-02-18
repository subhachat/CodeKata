package poc.liskov;

public class Office extends Building{
    @Override
    public String toString(){
        return "Office has many rooms";
    }
}
