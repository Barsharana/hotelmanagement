package org.jt.user.UserService.exception;

public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException(){
        super("Resource not found in the server...!");
    }
    public ResourcesNotFoundException(String message){
        super(message);
    }
}
