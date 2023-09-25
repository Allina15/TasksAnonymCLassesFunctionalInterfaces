import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        // Случайные буквы
        Supplier<Character> randomUpperCaseLetterSupplier = () -> {
            return (char) (random.nextInt(26) + 'A');
        };

        //  уникальные идентификаторы (UUID)
        Supplier<UUID> uuidSupplier = UUID::randomUUID;

        // постоянное значение
        Supplier<String> constantValueSupplier = () -> "Hello, World!";

        //  случайное слово из списка
        List<String> wordList = List.of("apple", "banana", "cherry", "date", "fine");
        Supplier<String> randomWordSupplier = () -> {
            int index = random.nextInt(wordList.size());
            return wordList.get(index);
        };

        // текущая дата в определенном формате
        Supplier<String> currentDateSupplier = () -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(new Date());
        };

        System.out.println("Random Letter: " + randomUpperCaseLetterSupplier.get());
        System.out.println("UUID: " + uuidSupplier.get());
        System.out.println("Constant Value: " + constantValueSupplier.get());
        System.out.println("Random Word: " + randomWordSupplier.get());
        System.out.println("Current Date: " + currentDateSupplier.get());

                //вычисления квадрата заданного числа
                Function<Integer, Integer> squareFunction = x -> x * x;
                int number = 5;
                int square = squareFunction.apply(number);
                System.out.println("Square of " + number + " is " + square);

                // преобразования первой буквы строки в заглавную
                Function<String, String> capitalizeFunction = str -> {
                    if (str == null || str.isEmpty()) {
                        return str;
                    }
                    return str.substring(0, 1).toUpperCase() + str.substring(1);
                };
                String inputString = "hello, world";
                System.out.println("Capitalized: " + capitalizeFunction.apply(inputString));

                // преобразования списка целых чисел в их квадраты
                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
                Function<List<Integer>, List<Integer>> squareListFunction = numList -> {
                    List<Integer> squares = new ArrayList<>();
                    for (int num : numList) {
                        squares.add(num * num);
                    }
                    return squares;
                };
                System.out.println("Squares: " + squareListFunction.apply(numbers));

                // Функция для вычисления среднего значения списка чисел
                List<Integer> numbers2 = Arrays.asList(10, 20, 30, 40, 50);
                Function<List<Integer>, Double> calculateFunction = numList -> {
                    if (numList.isEmpty()) {
                        return 0.0;
                    }
                    int sum = 0;
                    for (int num : numList) {
                        sum += num;
                    }
                    return (double) sum / numList.size();
                };
                System.out.println("Average: " + calculateFunction.apply(numbers2));

                // содержит ли строка только цифры
                Predicate<String> containsOnlyDigits = str -> str.matches("\\d+");
                String digitsString = "12345";
                String nonDigitsString = "abc123";
                System.out.println("Contains only digits: " + containsOnlyDigits.test(digitsString));
                System.out.println("Contains only digits: " + containsOnlyDigits.test(nonDigitsString));

                //  проверить, имеет ли человек право голоса в зависимости от его возраста
                Predicate<Integer> hasVotingRights = age -> age >= 18;
                int eligibleAge = 25;
                int underage = 15;
                System.out.println("Has voting rights: " + hasVotingRights.test(eligibleAge));
                System.out.println("Has voting rights: " + hasVotingRights.test(underage));

                //  список целых чисел в строго возрастающем порядке
                Predicate<List<Integer>> isStrictlyIncreasing = numberss -> {
                    for (int i = 1; i < numberss.size(); i++) {
                        if (numberss.get(i) <= numberss.get(i - 1)) {
                            return false;
                        }
                    }
                    return true;
                };
                List<Integer> increasingNumbers = Arrays.asList(1, 2, 3, 4, 5);
                List<Integer> nonIncreasingNumbers = Arrays.asList(1, 3, 2, 4, 5);
                System.out.println("Is strictly increasing: " + isStrictlyIncreasing.test(increasingNumbers));
                System.out.println("Is strictly increasing: " + isStrictlyIncreasing.test(nonIncreasingNumbers));

                //  фильтрация четных чисел
                Predicate<Integer> isEven = numberr -> numberr % 2 == 0;
                List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                List<Integer> evenNumbers = filterList(numbersList, isEven);
                System.out.println("Even numbers: " + evenNumbers);

                // Предикат, чтобы проверить, длиннее ли данная строка указанной длины
                int specifiedLength = 5;
                Predicate<String> isLongerThanSpecifiedLength = str -> str.length() > specifiedLength;
                String shortString = "Hello";
                String longString = "Hello, World!";
                System.out.println("Is longer than specified length: " + isLongerThanSpecifiedLength.test(shortString));
                System.out.println("Is longer than specified length: " + isLongerThanSpecifiedLength.test(longString));

        // соответствуют ли возраст и доход человека определенным критериям для получения кредита
        BiPredicate<Integer, Double> isCreditEligible = (age, income) -> age >= 18 && income >= 25000.0;
        int eligibleAge2 = 25;
        double eligibleIncome = 30000.0;
        int nonEligibleAge = 16;
        double nonEligibleIncome = 20000.0;
        System.out.println("Is credit eligible: " + isCreditEligible.test(eligibleAge2, eligibleIncome));
        System.out.println("Is credit eligible: " + isCreditEligible.test(nonEligibleAge, nonEligibleIncome));

        // проверить, имеют ли два списка одинаковый размер
        BiPredicate<List<?>, List<?>> haveSameSize = (list1, list2) -> list1.size() == list2.size();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<String> list2 = Arrays.asList("a", "b", "c");
        List<Integer> list3 = Arrays.asList(10, 20, 30, 40);
        System.out.println("Have same size: " + haveSameSize.test(list1, list2));
        System.out.println("Have same size: " + haveSameSize.test(list1, list3));

        //вычисления площади прямоугольника
        BiFunction<Integer, Integer, Integer> rectangleAreaCalculator = (length, width) -> length * width;
        int length = 5;
        int width = 10;
        int area = rectangleAreaCalculator.apply(length, width);
        System.out.println("Rectangle Area: " + area);

        // Бифункция для объединения двух строк
        BiFunction<String, String, String> stringMerger = (str1, str2) -> str1 + " | " + str2;
        String firstString = "Hello";
        String secondString = "World!";
        String mergedString = stringMerger.apply(firstString, secondString);
        System.out.println("Merged String: " + mergedString);

        // вычисления степени одного числа, возведенного в другое
        BiFunction<Integer, Integer, Double> powerCalculator = (base, exponent) -> Math.pow(base, exponent);
        int base = 2;
        int exponent = 3;
        double result = powerCalculator.apply(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is " + result);

        //поиск максимального элемента
        BiFunction<List<Integer>, Integer, Integer> maxInRangeFinder = (numbers3, range) -> {
            List<Integer> filteredList = new ArrayList<>();
            for (int number3 : numbers3) {
                if (number3 <= range) {
                    filteredList.add(number3);
                }
            }
            return Collections.max(filteredList);
        };
        List<Integer> numberList = Arrays.asList(3, 7, 2, 9, 4, 6);
        int maxInRange = maxInRangeFinder.apply(numberList, 5);
        System.out.println("Max in range: " + maxInRange);

        // вычисления гипотенузы прямоугольного треугольника
        BiFunction<Double, Double, Double> hypotenuseCalculator = (side1, side2) -> Math.sqrt(side1 * side1 + side2 * side2);
        double sideA = 3.0;
        double sideB = 4.0;
        double hypotenuse = hypotenuseCalculator.apply(sideA, sideB);
        System.out.println("Hypotenuse: " + hypotenuse);


            }


            public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
                List<T> filteredList = new ArrayList<>();
                for (T item : list) {
                    if (predicate.test(item)) {
                        filteredList.add(item);
                    }
                }
                return filteredList;

    }
}
