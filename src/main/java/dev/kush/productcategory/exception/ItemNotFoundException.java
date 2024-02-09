package dev.kush.productcategory.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }

    public ItemNotFoundException(){
        super("item not found");
    }
}
