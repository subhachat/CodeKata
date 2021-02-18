package poc.basic;

public class RunStringOps {
    public static void main(String[] args){
        String firstName = "Subhadip";
        String lastName = "Chatterjee";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        String concatName = firstName.concat(" ").concat(lastName);

        System.out.println("----------------");
        StringBuilder strBuilder = new StringBuilder("abc");
        strBuilder.append("def").append("ghi");
        System.out.println(strBuilder.toString());
        strBuilder.insert(0, "xyz");
        System.out.println(strBuilder.toString());
        strBuilder.delete(3, 6);
        System.out.println(strBuilder.toString());

        System.out.println("----------------");
        StringBuffer strBuffer = new StringBuffer("abc");
        strBuffer.append("def").append("ghi");
        System.out.println(strBuffer.toString());
        strBuffer.insert(0, "xyz");
        System.out.println(strBuffer.toString());
        strBuffer.delete(3, 6);
        System.out.println(strBuffer.toString());

    }
}
