//Super class ID contains only one field ID which will be the key element of other classes
package com.army.models;
public class ID {
    private int id;

    public ID(){

    }
    public ID(int id){
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID{" +
                "id=" + id +
                '}';
    }
}
