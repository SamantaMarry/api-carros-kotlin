package com.wswork.teste.samantamarry.apicarros.service

import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.builder
import com.wswork.teste.samantamarry.apicarros.domain.Cars
import com.wswork.teste.samantamarry.apicarros.domain.Factories
import com.wswork.teste.samantamarry.apicarros.repository.CarsRepository
import org.apache.commons.collections4.IteratorUtils
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.hibernate.tool.schema.extract.internal.IndexInformationImpl.builder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.math.BigDecimal
import java.util.function.Consumer


@Service
class CarsService @Autowired constructor(private val repository: CarsRepository) {
    @Throws(IOException::class)
    fun uploadAndSave(file: MultipartFile) {
        val carros = converterEmObjeto(file)
        salvar(carros)
    }

    @Throws(IOException::class)
    private fun converterEmObjeto(file: MultipartFile): List<Cars> {
        val workbook: Workbook = XSSFWorkbook(file.inputStream)
        val sheet = workbook.getSheetAt(0)
        val rows = toList(sheet.iterator()) as List<Row>
        val cars: MutableList<Cars> = ArrayList()
        rows.drop(0)
        rows.forEach(Consumer { row: Row ->
            val cells =
                toList(row.cellIterator()) as List<Cell>

            val car: Cars = Cars.builder()
                .id(cells[0].numericCellValue.toInt())
                .factories(
                    Factories.builder()
                        .id(cells[1].numericCellValue.toInt())
                        .name(cells[2].stringCellValue)
                        .build()
                )
                .modal(cells[3].stringCellValue)
                .year(cells[4].numericCellValue.toInt())
                .fuel(cells[5].stringCellValue)
                .doors(cells[6].numericCellValue.toInt())
                .cost(BigDecimal.valueOf(cells[7].numericCellValue))
                .color(cells[8].stringCellValue)
                .build()
            cars.add(car)
        })
        return cars
    }

    private fun salvar(carros: List<Cars>) {
        repository.saveAll(carros)
    }

    fun toList(iterator: Iterator<*>?): List<*> {
        return IteratorUtils.toList(iterator)
    }
}