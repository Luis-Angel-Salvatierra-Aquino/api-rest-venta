package pe.edu.idat.api_rest_ventas.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
