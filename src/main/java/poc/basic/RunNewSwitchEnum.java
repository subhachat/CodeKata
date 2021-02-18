package poc.basic;

public class RunNewSwitchEnum {
    public static void main(String[] args) {
        SEASONS selectedOne = SEASONS.SPRING;

        String weather = switch (selectedOne) {
            case SPRING, SUMMER -> "Sunny";
            case FALL -> "rainy";
            case WINTER -> "Snowy";
            default -> {
                System.out.println("Invalid Season");
                yield "Invalid weather";
            }
        };

        System.out.println(weather);
    }

    enum SEASONS {SPRING, SUMMER, FALL, WINTER}
}
