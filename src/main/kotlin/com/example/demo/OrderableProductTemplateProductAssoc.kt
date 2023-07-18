package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.io.Serializable
import java.util.UUID

@Entity
@IdClass(OrderableProductTemplateProductAssocId::class)
class OrderableProductTemplateProductAssoc(
    orderableVendorProduct: OrderableVendorProduct,
    orderableProductTemplate: OrderableProductTemplate,
) : Serializable {
    init {
        orderableVendorProduct.addOrderableProductTemplateAssoc(this)
    }

    @Id
    val orderableVendorProductId: UUID = orderableVendorProduct.id
    @Id
    val orderableProductTemplateId: UUID = orderableProductTemplate.id

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderableVendorProductId", nullable = false, insertable = false, updatable = false)
    val orderableVendorProduct: OrderableVendorProduct = orderableVendorProduct


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderableProductTemplateId", nullable = false, insertable = false, updatable = false)
    val orderableProductTemplate: OrderableProductTemplate = orderableProductTemplate
}

private class OrderableProductTemplateProductAssocId : Serializable{
    private lateinit var orderableVendorProductId: UUID
    private lateinit var orderableProductTemplateId: UUID
}

