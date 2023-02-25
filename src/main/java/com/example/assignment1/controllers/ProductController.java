package com.example.assignment1.controllers;

import com.example.assignment1.config.QueryHelper;
import com.example.assignment1.models.Pageable;
import com.example.assignment1.models.Product;
import com.example.assignment1.models.Response;
import com.example.assignment1.services.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("assignment/v1/products")
public class ProductController implements BaseController<Product, Product>{

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Response<Product>> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Product>builder()
                                        .status(200)
                                        .message("Data found")
                                        .payload(productOptional.get())
                                        .build()
                        );
    }

    @Override
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "data found", content = {
            @Content(mediaType = "application/json")})})
   /* @Parameters({
            @Parameter(name = "pageNo", in = ParameterIn.QUERY, schema = @Schema(type = "int", defaultValue = "1")),
            @Parameter(name = "pageSize", in = ParameterIn.QUERY, schema = @Schema(type = "int", defaultValue = "20")),
            @Parameter(name = "sortBy", in = ParameterIn.QUERY, schema = @Schema(type = "string"), example = "createdAt:desc")
    })*/
    @GetMapping
    public ResponseEntity<?> findAll(
            /*@Parameter(hidden = true) Specification<Product> specification,
            @Parameter(hidden = true) Pageable pageable*/) {

        List<Product> productList = new ArrayList<>();

        /*if(pageable.getPageNo() == null) {
            productList = productService.findAll(specification, QueryHelper.getSort(pageable.getSortBy()));
        }*/
        productList = productService.findAll();

        //Page<Product> productPage = productService.findAll(specification, QueryHelper.getPageRequest(pageable));
       // productList = productPage.get().collect(Collectors.toList());
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<List<Product>>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(productList)
                                        .build()
                        );

    }

    @Override
    @PostMapping
    public ResponseEntity<Response<Product>> save(@RequestBody Product param) {
        Optional<Product> productOptional = productService.save(param);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Product>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(productOptional.get())
                                        .build()
                        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Response<Product>> update(@PathVariable Long id, @RequestBody Product param) {
        Optional<Product> productOptional = productService.update(id, param);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Product>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(productOptional.get())
                                        .build()
                        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable  Long id) {
        productService.deleteById(id);
        return ResponseEntity
                .status(200)
                .body(
                        Response.<Product>builder()
                                .status(200)
                                .message("Delete successfully")
                                .build()
                );
    }
}
