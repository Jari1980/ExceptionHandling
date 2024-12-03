package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Names {
    private Collection<String> list = new ArrayList<>();;

    public Names() {
            list.add("Good Broccoli");
            list.add("Green Broccoli");
            list.add("Super Broccoli");
            list.add("Christmas Broccoli");
            list.add("Summer Broccoli");
    }

    public  Collection<String> getList() {
        return list;
    }

    public void findName(String name){
        if(!list.contains(name)){
            try{
                throw new NameNotFoundException("The name cant be find in the great Broccoli list");
            }
            catch(NameNotFoundException e){
                System.out.println("The name cant be find in the great Broccoli list");
            }
        }
        else{
            System.out.println("Name found");
        }
    }

    public void addGoodie(String name){
        if(!list.contains(name)){
            list.add(name);
            System.out.println(name + " added to list");
        }
        else{
            try{
                throw new DuplicateNameException("There can Only Be One Broccoli!");
            }
            catch(DuplicateNameException e){
                System.out.println("There can Only Be One Broccoli!");
            }

        }
    }

}
