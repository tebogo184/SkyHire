package com.SkyHire.project.ExceptionHandle;

public class ResourceNotFoundException extends RuntimeException{

   public  ResourceNotFoundException(String message){
        super(message);
    }

}
