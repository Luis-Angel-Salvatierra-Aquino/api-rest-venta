package pe.edu.idat.api_rest_ventas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid;
    private String categoryname;
    private String description;
}
