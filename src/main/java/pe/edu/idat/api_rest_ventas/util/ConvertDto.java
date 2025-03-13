package pe.edu.idat.api_rest_ventas.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.idat.api_rest_ventas.dto.DtoEntity;

@Component
public class ConvertDto {

    public DtoEntity convertirADto(
            Object object, DtoEntity dto){
        return new ModelMapper().map(object,
                dto.getClass());
    }

}
