package com.wswork.teste.samantamarry.apicarros.repository

import com.wswork.teste.samantamarry.apicarros.domain.Cars
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarsRepository : JpaRepository<Cars?, Long?>
