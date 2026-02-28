package com.example;

import java.util.List;

public class Alex extends Lion {

    private final String NEW_YORK_ZOO = "Нью-Йоркский зоопарк";
    private final List<String> ALEX_FRIENDS_LIST = List.of("Марти", "Глория", "Мелман");
    private final int DEFAULT_KITTENS = 0;

    public Alex(Feline feline) throws Exception {
        super(feline, "Самец");
    }

    public List<String> getFriends() {
        return ALEX_FRIENDS_LIST;
    }

    public String getPlaceOfLiving() {
        return NEW_YORK_ZOO;
    }

    @Override
    public int getKittens() {
        return DEFAULT_KITTENS;
    }
}
