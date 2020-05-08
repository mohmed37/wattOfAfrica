package com.tests.web.controler;

import com.tests.dao.ndream.PhotoRepositories;
import com.tests.entity.ndream.Photo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestNbreamControler {

    @Autowired
    PhotoRepositories photoRepositories;

    @PostMapping(value = "/photo")
    public ResponseEntity<Photo> savePhoto(@RequestBody Photo photo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return null;
        }

        Photo savePhoto = photoRepositories.save(photo);

        return new ResponseEntity<Photo>(savePhoto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/listPhotos")
    public List<Photo> listPhotos(){

        return photoRepositories.findAll();
    }




}
