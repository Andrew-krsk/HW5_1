package HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников:Иван Иванов (и остальные)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
//        Иван Иванов 88001122333
//        Иван Курицин 88001662333
//        Иван Курицин 88001112333
//        Иван Незлобин 88001122432
//        Сергей Потапов 88001112453
//        Сергей Потапов 8800163214
//        Сергей Курицин 8800142421
//        Михаил Незлобин 880012343
//        OutPut
//        Иван - 3
//        Сергей - 2
//        Потому как если один сотрудник имеет 2 или более номера , его имя считаем 1 раз.

public class task0 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = createPhoneBook();
        System.out.println(phoneBook);
        Map<String, Integer> sortedPhoneBook = new TreeMap<>();
        sortedPhoneBook = (HashMap<String, Integer>) SortBook(phoneBook);
        System.out.println(sortedPhoneBook);

    }

    public static void addNumber(String key, String value, Map<String, ArrayList<String>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }

    public static Map<String, Integer> SortBook(Map<String, ArrayList<String>> map) {
        Map<String, Integer> tmap = new HashMap<>();
        for (String s : map.keySet()) {
            tmap.put(s, map.get(s).size());
        }
        return tmap;
    }

    public static Map<String, ArrayList<String>> createPhoneBook() {
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        addNumber("Иван Иванов", "88001122333", phoneBook);
        addNumber("Иван Курицин", "88001662333", phoneBook);
        addNumber("Иван Курицин", "88001112333", phoneBook);
        addNumber("Иван Незлобин", "88001122432", phoneBook);
        addNumber("Сергей Потапов", "88001112453", phoneBook);
        addNumber("Сергей Потапов", "8800163214", phoneBook);
        addNumber("Сергей Курицин", "8800142421", phoneBook);
        addNumber("Михаил Незлобин", "880012343", phoneBook);

        return phoneBook;
    }

}
