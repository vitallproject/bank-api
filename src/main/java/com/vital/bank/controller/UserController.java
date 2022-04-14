package com.vital.bank.controller;

import com.vital.bank.dto.UserReadDto;
import com.vital.bank.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserReadDto>> findAll() {
        log.info("Reading all users");

        return new ResponseEntity<>(userService.findALl(), HttpStatus.OK);
    }

    @GetMapping(value = "/{identification}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserReadDto findByIdentificationNumber(@PathVariable("identification") String identification) {
        log.info("Reading user by identificationNumber {}", identification);

        return userService.findByIdentificationNumber(identification)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
