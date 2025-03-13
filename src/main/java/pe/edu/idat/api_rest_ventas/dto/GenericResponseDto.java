package pe.edu.idat.api_rest_ventas.dto;

public class GenericResponseDto<T> {
    private T respuesta;
    private String error;
    private Integer statusCode;

    public T getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(T respuesta) {
        this.respuesta = respuesta;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
