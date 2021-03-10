package poc.basic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainJavaValidator {
    public static void main(String... args) {
        //if (currencyFormatter()) return;

        /*getSmallestAndLargest("welcometojava", 3);
        getSmallestAndLargest
        ("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs", 30);*/

        /*Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");*/

        /*printStringTokens("He is a very very good boy, isn't he?");
        printStringTokens("           YES      leading spaces        are
        valid,    problemsetters are         evillllll");
        printStringTokens("                        ");*/

        /*funcRegexMatch("000.12.12.034");
        funcRegexMatch("00.12.123.123123.123");
        funcRegexMatch("122.23");
        funcRegexMatch("Hello.IP");*/

        /*funcDuplicateWordsMatch("Goodbye bye bye world world world");
        funcDuplicateWordsMatch("Hello hello Ab aB");
        funcDuplicateWordsMatch("in inthe");
        funcDuplicateWordsMatch("Sam went went to to to his business");*/

        /*validUsernamePolicyChecker("8");
        validUsernamePolicyChecker("1Samantha");
        validUsernamePolicyChecker("_Julia007");
        validUsernamePolicyChecker("Julia007_");
        validUsernamePolicyChecker("Julia@007");*/

        /*recurse("<h1>Nayeem loves counseling</h1>");
        System.out.println("========");
        recurse("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a " +
                "while</par>");
        System.out.println("========");
        recurse("<Amee>safat codes like a ninja</amee>");
        System.out.println("========");
        recurse("<SA premium>Imtiaz has a secret crush</SA premium>");
        System.out.println("========");
        recurse("<h1>had<h1>public</h1></h1>");
        System.out.println("========");
        recurse("<h1>had<h1>public</h1515></h1>");
        System.out.println("========");
        recurse("<h1><h1></h1></h1>");*/

        /*balancedString("({}[])");
        balancedString("(({()})))");
        balancedString("({(){}()})()({(){}()})(){()}");
        balancedString("{}()))(()()({}}{}");
        balancedString("}}}}");
        balancedString("))))");
        balancedString("{{{");
        balancedString("(((");
        balancedString("[]{}(){()}((())){{{}}}{()()}{{}{}}");
        balancedString("[[]][][]");
        balancedString("}{");*/

        /*uniqueStringPair(new String[]{"john", "john", "john", "mary", "mary"},
                new String[]{
                        "tom", "mary", "tom", "anna", "anna"});*/

    }

    private static boolean currencyFormatter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number->");
        double payment = scanner.nextDouble();
        scanner.close();

        if (payment < 0 || payment > Math.pow(10, 9)) {
            return true;
        }
        NumberFormat formatter;
        formatter = NumberFormat.getCurrencyInstance(new Locale("zh", "CN"));
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        formatter.setMaximumFractionDigits(2);
        String china = formatter.format(payment);
        formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        formatter.setMaximumFractionDigits(2);
        String us = formatter.format(payment);
        formatter = NumberFormat.getCurrencyInstance(new Locale("fr", "FR"));
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        formatter.setMaximumFractionDigits(2);
        String france = formatter.format(payment);
        formatter = NumberFormat.getNumberInstance(new Locale("en", "IN"));
        DecimalFormat df = (DecimalFormat) formatter;
        df.applyPattern("#,##,##0.00");
        //df.setRoundingMode(RoundingMode.HALF_UP);
        //df.setMaximumFractionDigits(2);
        String india = "Rs." + df.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
        return false;
    }

    public static void checkPalindrome(String str) {
        StringBuilder buffer = new StringBuilder(str);
        if (buffer.reverse().toString().equals(str)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of
        // length 'k'
        // 'largest' must be the lexicographically largest substring of
        // length 'k'
        List<String> output = new ArrayList<>();
        for (int counter = 0; counter < s.length() - k + 1; counter++) {
            output.add(s.substring(counter, counter + k));
        }
        output.sort(Comparator.naturalOrder());
        return smallest + "\n" + largest;
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() < 1 || a.length() > 50
                || b.length() < 1 || b.length() > 50
                || a.length() != b.length()) {
            return false;
        }
        Map<Integer, Integer> mapOfCharacters = new HashMap<>(); //
        // {character, count}
        a.toLowerCase().chars().forEach(ascii -> {
            if (mapOfCharacters.containsKey(ascii)) {
                mapOfCharacters.put(ascii, mapOfCharacters.get(ascii) + 1);
            } else {
                mapOfCharacters.put(ascii, 1);
            }
        });
        //System.out.println("Track 1---->" + mapOfCharacters);

        b.toLowerCase().chars().forEach(ascii -> {
            if (mapOfCharacters.containsKey(ascii)) {
                mapOfCharacters.put(ascii, mapOfCharacters.get(ascii) - 1);
            } else {
                mapOfCharacters.put(ascii, 1);
            }
        });
        //System.out.println("Track 2---->" + mapOfCharacters);

        boolean isNotAnagram =
                mapOfCharacters.values().parallelStream().anyMatch(value -> value.intValue() != 0);
        return !isNotAnagram;
    }

    public static void printStringTokens(String str) {
        Objects.requireNonNull(str);
        if (str.trim().isEmpty()) {
            System.out.println(0);
            return;
        }
        String regex_wordToken = "[\\s!,._'@\\?!]+";
        String[] tokenArray = str.trim().split(regex_wordToken);
        //System.out.println("Print->" + Arrays.toString(tokenArray));
        System.out.println(tokenArray.length);
        Arrays.stream(tokenArray).forEach(item -> System.out.println(item.trim()));
    }

    public static void funcRegexMatch(String str) {
        final String regex_zeroTo255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
        final String pattern = regex_zeroTo255 + "\\."
                + regex_zeroTo255 + "\\."
                + regex_zeroTo255 + "\\."
                + regex_zeroTo255;
        final Pattern PATTERN_IPADDR = Pattern.compile(pattern);
        System.out.println(PATTERN_IPADDR.matcher(str).matches());
    }

    public static void funcDuplicateWordsMatch(String input) {
        String regex = "\\b(\\w+)(\\s*\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println(m.group());
            input = input.replaceAll(m.group(), m.group().split("\\s+")[0]);
        }
        // Prints the modified sentence.
        System.out.println(input);
        System.out.println("========");
    }

    public static void validUsernamePolicyChecker(String input) {
        /**
         * Rules:
         * 1. User name must be 8 and 30 characters long
         * 2. user name can have only alphanumeric and underscore
         * 3. first character must be an alpha
         */
        final String regularExpression = "([a-zA-Z]{1})(\\w{7,29})";
        if (input.matches(regularExpression)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static void recurse(String input) {
        String regex_fragment1 = "<(.+)>([^<]+)</\\1>"; //<tag1>...</tag1>
        String regex_open_close_tag = regex_fragment1;
        Pattern pattern = Pattern.compile(regex_open_close_tag);
        Matcher matcher = pattern.matcher(input);
        boolean anyMatch = false;
        while (matcher.find()) {
            anyMatch = true;
            System.out.println(matcher.group(2));
        }
        if (!anyMatch) {
            System.out.println("None");
        }
    }

    private static void balancedString(String input) {
        System.out.println("Input -> " + input);
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (!stack.isEmpty() &&
                    (
                            (ch == ')' && stack.peek() == '(')
                                    || ((ch == '}' && stack.peek() == '{'))
                                    || ((ch == ']' && stack.peek() == '['))
                    )
            ) {
                stack.pop();
            } else {
                stack.push(ch);
            }
            //System.out.println(stack);
        }
        System.out.println(stack.isEmpty() ? "true" : "false");
    }

    private static void uniqueStringPair(String[] pair_left,
                                         String[] pair_right) {
        Set<String> pairs = new HashSet<>();
        int uniqueCount = 0;
        for (int counter = 0; counter < pair_left.length; counter++) {
            String tmp = pair_left[counter] + "," + pair_right[counter];
            if (!pairs.contains(tmp)) {
                pairs.add(tmp);
                uniqueCount++;
            }
            System.out.println(uniqueCount);
        }
    }

    private static <T> void printGenericArray(T[] type) {
        Arrays.stream(type).forEach(System.out::println);
        /*for(T entry : type){
            System.out.println(entry);
        }*/
    }

    private static void dequeueProblem() {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        int n = in.nextInt(); // sample value = 6
        int m = in.nextInt(); // sample value = 3

        int maxNumOfUniqueInSubsets = 0;
        // sample data input: {5,3,5,2,3,2}
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num); //auto-boxed
            set.add(num);
            if (deque.size() == m) { //reached the end of subset
                if (set.size() > maxNumOfUniqueInSubsets) {
                    maxNumOfUniqueInSubsets = set.size();
                }
                // ready for the next subset
                int removedElement = deque.removeFirst().intValue();
                if (!deque.contains(removedElement)) {
                    set.remove(removedElement);
                }
            }
        }

        System.out.println(maxNumOfUniqueInSubsets);
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    /**
     * Rule 1: Sort Players by Score decreasing order Rule 2: if same score,
     * sort by names in alphabetical order
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Player o1, Player o2) {
        return (o1.score == o2.score ? o1.name.compareTo(o2.name) :
                Integer.valueOf(o2.score).compareTo(Integer.valueOf(o1.score)));
    }
}

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Checker2 implements Comparator<Student> {
    /**
     * Rule 1: sort Students by CGPA decreasing order\n Rule 2: if same CGPA,
     * sort by first names in alphabetical order\n Rule 3: if same first names,
     * sort by ID in alphabetical order
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getCgpa() == o2.getCgpa()) {
            if (o1.getFname().equals(o2.getFname())) {
                //apply Rule 3
                return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId()));
            } else {
                //apply Rule 2
                return o1.getFname().compareTo(o2.getFname());
            }
        } else {
            //apply Rule 1
            return Double.valueOf(o2.getCgpa()).compareTo(Double.valueOf(o1.getCgpa()));
        }
    }
}



