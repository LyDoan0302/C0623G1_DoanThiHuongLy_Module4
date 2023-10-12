package com.codegym.dictionary.service;

import com.codegym.dictionary.repository.IDicRepository;
import com.codegym.dictionary.repository.DicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicService implements IDicService {

    @Autowired
    private IDicRepository dicRepository;
    @Override
    public String findWord(String english) {
        return dicRepository.findWord(english);
    }
}
