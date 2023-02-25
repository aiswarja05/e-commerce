package com.example.assignment1.controllers;

import com.example.assignment1.config.QueryHelper;
import com.example.assignment1.models.Pageable;
import com.example.assignment1.models.Purchase;
import com.example.assignment1.models.Response;
import com.example.assignment1.services.PurchaseService;
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
@RequestMapping("assignment/v1/purchases")
public class PurchaseController implements BaseController<Purchase, Purchase>{

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Response<Purchase>> findById(@PathVariable Long id) {
        Optional<Purchase> purchaseOptional = purchaseService.findById(id);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Purchase>builder()
                                        .status(200)
                                        .message("Data found")
                                        .payload(purchaseOptional.get())
                                        .build()
                        );
    }

    @Override
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "data found", content = {
            @Content(mediaType = "application/json")})})
    @GetMapping
    public ResponseEntity<?> findAll() {

        List<Purchase> purchaseList = new ArrayList<>();

            purchaseList = purchaseService.findAll();
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<List<Purchase>>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(purchaseList)
                                        .build()
                        );

    }

    @Override
    @PostMapping
    public ResponseEntity<Response<Purchase>> save(@RequestBody Purchase param) {
        Optional<Purchase> purchaseOptional = purchaseService.save(param);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Purchase>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(purchaseOptional.get())
                                        .build()
                        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Response<Purchase>> update(@PathVariable Long id, @RequestBody Purchase param) {
        Optional<Purchase> purchaseOptional = purchaseService.update(id, param);
        return
                ResponseEntity
                        .status(200)
                        .body(
                                Response.<Purchase>builder()
                                        .status(200)
                                        .message("Data saved")
                                        .payload(purchaseOptional.get())
                                        .build()
                        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable  Long id) {
        purchaseService.deleteById(id);
        return ResponseEntity
                .status(200)
                .body(
                        Response.<Purchase>builder()
                                .status(200)
                                .message("Delete successfully")
                                .build()
                );
    }
}
