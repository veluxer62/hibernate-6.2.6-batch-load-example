package com.example.demo

import java.util.UUID
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val orderableProductTemplateRepository: OrderableProductTemplateRepository,
    private val orderableVendorProductRepository: OrderableVendorProductRepository,
) {
    @Transactional
    @GetMapping("/test1")
    fun create(): UUID {
        val template = OrderableProductTemplate("테스트")

        val products = (0..100).map { OrderableVendorProduct("PRODUCT_$it") }

        orderableProductTemplateRepository.save(template)
        orderableVendorProductRepository.saveAll(products)

        template.addOrderableProducts(products)

        return template.id
    }

    @GetMapping("/test2/{id}")
    fun get(@PathVariable id: UUID): List<ProductDto> {
        val template = orderableProductTemplateRepository.getReferenceById(id)
        return template.orderableProducts.map { ProductDto(it.name) }
    }
}


data class ProductDto(
    val name: String
)
