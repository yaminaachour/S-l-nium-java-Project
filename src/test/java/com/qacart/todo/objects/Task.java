package com.qacart.todo.objects;
 //1 ze ztape  tjr ouvrir inspzct--> tqkssapi
public class Task {

    // Déclaration des attributs de la classe
    private String item;
    private boolean isCompleted;
// CONSTRACTEUT

    public Task(String item, boolean isCompleted) {
        this.isCompleted = isCompleted;
        this.item = item;
    }
//  getters et setters
public boolean getIsCompleted() {
    return isCompleted;
}

     public void setIsCompleted(boolean completed) {
         isCompleted = completed;
     }

     public String getItem() {
         return item;
     }

     public void setItem(String item) {
         this.item = item;
     }

}


