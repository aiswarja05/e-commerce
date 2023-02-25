package com.example.assignment1.controllers;

import com.example.assignment1.config.QueryHelper;
import com.example.assignment1.models.Pageable;
import com.example.assignment1.models.Customer;
import com.example.assignment1.models.Response;
import com.example.assignment1.services.CustomerService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("assignment/v1/customers")
public class CustomerController implements BaseController<Customer, Customer>{

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Response<Customer>> findById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Customer>builder()
                                        .status(200)
                                        .message("Data found")
                                        .payload(customerOptional.get())
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
    public ResponseEntity<?> findAll() {

        List<Customer> customerList = new ArrayList<>();
        customerList = customerService.findAll();
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<List<Customer>>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(customerList)
                                        .build()
                        );

    }

    @Override
    @PostMapping
    public ResponseEntity<Response<Customer>> save(@RequestBody Customer param) {
        Optional<Customer> customerOptional = customerService.save(param);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Customer>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(customerOptional.get())
                                        .build()
                        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Response<Customer>> update(@PathVariable Long id, @RequestBody Customer param) {
        Optional<Customer> customerOptional = customerService.update(id, param);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Customer>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(customerOptional.get())
                                        .build()
                        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable  Long id) {
        customerService.deleteById(id);
        return ResponseEntity
                .status(200)
                .body(
                        Response.<Customer>builder()
                                .status(200)
                                .message("Delete successfully")
                                .build()
                );
    }
}
