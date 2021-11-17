package com.wswork.teste.samantamarry.apicarros.domain


import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.math.BigDecimal
import javax.persistence.*

@Entity
class Cars() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "factories_id")
    private val factories: Factories? = null
    private val modal: String? = null
    private val year: Int? = null
    private val fuel: String? = null
    private val doors: Int? = null
    private val cost: BigDecimal? = null
    private val color: String? = null




}






