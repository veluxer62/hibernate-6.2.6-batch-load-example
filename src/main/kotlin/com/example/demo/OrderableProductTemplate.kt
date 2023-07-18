package com.example.demo

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class OrderableProductTemplate(
    name: String,
) : PrimaryKeyEntity() {
    @Column(nullable = false)
    var name: String = name
        protected set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderableProductTemplate", cascade = [CascadeType.ALL], orphanRemoval = true)
    protected val _orderableProductAssocs: MutableList<OrderableProductTemplateProductAssoc> = mutableListOf()
    val orderableProducts get() = _orderableProductAssocs.map { it.orderableVendorProduct }

    fun addOrderableProducts(orderableVendorProducts: List<OrderableVendorProduct>) {
        orderableVendorProducts.forEach { addOrderableProduct(it) }
    }

    private fun addOrderableProduct(orderableVendorProduct: OrderableVendorProduct) {
        _orderableProductAssocs.add(
            OrderableProductTemplateProductAssoc(
                orderableVendorProduct = orderableVendorProduct,
                orderableProductTemplate = this,
            ),
        )
    }
}

