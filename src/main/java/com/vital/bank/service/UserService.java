package com.vital.bank.service;

import com.vital.bank.database.repository.UserRepository;
import com.vital.bank.dto.UserReadDto;
import com.vital.bank.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserReadMapper userReadMapper;
    private final UserRepository userRepository;

    public List<UserReadDto> findALl() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findByIdentificationNumber(String identificationNumber) {
        return userRepository.findByIdentificationNumber(identificationNumber)
                .map(userReadMapper::map);
    }
}

