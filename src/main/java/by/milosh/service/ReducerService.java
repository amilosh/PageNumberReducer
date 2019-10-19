package by.milosh.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReducerService {

    public String reduce(String raw) {
        List<Integer> list = rawOfNumbersToSortedList(raw);

        StringBuilder str = new StringBuilder();
        str.append(list.get(0));
        if (list.size() == 1) {
            return str.toString();
        } else if (list.size() == 2) {
            return str.append(",").append(list.get(1)).toString();
        }
        if (list.get(0) + 1 != list.get(1)) {
            str.append(",");
        }
        for (int i = 1; i < list.size() - 1; i++) {
            int previous = list.get(i - 1);
            int current = list.get(i);
            int next = list.get(i + 1);
            if (current - 1 == previous) {
                if (current + 1 != next) {
                    str.append("-").append(current).append(",");
                }
            } else {
                if (current + 1 == next) {
                    str.append(current);
                } else if (current + 1 != next) {
                    str.append(current).append(",");
                }
            }
        }
        int last = list.get(list.size() - 1);
        int preLast = list.get(list.size() - 2);
        if (last - 1 == preLast) {
            str.append("-").append(last);
        } else {
            str.append(last);
        }
        return str.toString();
    }

    private List<Integer> rawOfNumbersToSortedList(String raw) {
        String[] array = raw.split(",");
        List<Integer> list = new ArrayList<>();
        for (String str : array) {
            list.add(Integer.parseInt(str));
        }
        Collections.sort(list);
        return list;
    }
}
