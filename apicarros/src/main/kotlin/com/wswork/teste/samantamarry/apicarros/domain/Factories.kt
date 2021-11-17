package com.wswork.teste.samantamarry.apicarros.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id



@Entity
class Factories {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id = 0
        private val name: String? = null
        private val country_code: Int? = null

}