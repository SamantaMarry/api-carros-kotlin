package com.wswork.teste.samantamarry.apicarros.controller

import com.wswork.teste.samantamarry.apicarros.service.CarsService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

class CarsController {

    @Slf4j
    @RestController
    @RequestMapping("/cars")
    class CarsController @Autowired constructor(carsService: CarsService) {
        private val carsService: CarsService
        @PostMapping
        fun upload(@RequestParam("file") file: MultipartFile ) {
            try {
                carsService.uploadAndSave(file)
            } catch (e: Exception) {

            }
        }

        init {
            this.carsService = carsService
        }
    }
}