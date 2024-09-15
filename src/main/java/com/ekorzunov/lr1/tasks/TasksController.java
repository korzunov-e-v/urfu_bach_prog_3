package com.ekorzunov.lr1.tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class TasksController {

    private static ArrayList<String> arrayList;
    private static HashMap<Integer, String> hashMap;
    private Integer hashMapInc = 0;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        if (Objects.equals(arrayList, null)) {
            arrayList = new ArrayList<String>();
        }
        arrayList.add(s);

        return "";
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return Objects.toString(arrayList);
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (Objects.equals(hashMap, null)) {
            hashMap = new HashMap<Integer, String>();
        }

        hashMap.put(hashMapInc, s);
        hashMapInc++;

        return "";
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return Objects.toString(hashMap);
    }

    @GetMapping("/show-all-lenght")
    public String showAllLength() {
        int arrayListSize = 0;
        int hashMapSize = 0;

        if (!Objects.equals(arrayList, null)) {
            arrayListSize = arrayList.size();
        }
        if (!Objects.equals(hashMap, null)) {
            hashMapSize = hashMap.size();
        }

        return String.format("arrayList.length = %d; \nhashMap.length = %d;", arrayListSize, hashMapSize);
    }

}
