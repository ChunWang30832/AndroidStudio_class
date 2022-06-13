package com.example.android.finalproject;

import java.util.ArrayList;

public class Cart {
    public ArrayList<String> cartItem;
    public ArrayList<Integer> cartCount; //加入購物車的次數ArrayList


    public Cart() {
        cartItem = new ArrayList<>();
        cartCount = new ArrayList<>();
        cartItem.clear();
        cartCount.clear();
    }

    public void Add(String item) {
        for(int i =  0; i < cartItem.size(); i++) {
            if(cartItem.get(i) == item) {
                return;
            }
        }
        cartItem.add(item);
        cartCount.add(0);
    }

    public void addCount(String item) {
        int index;
        for(index = 0; index < cartItem.size(); index++) {
            if(cartItem.get(index) == item){
                break;
            }
        }
        cartCount.set(index, cartCount.get(index) + 1);
    }
}
