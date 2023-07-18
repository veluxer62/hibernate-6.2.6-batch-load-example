package com.example.demo

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity
class OrderableVendorProduct(
    name: String,
): PrimaryKeyEntity() {
    @Column(nullable = false)
    var name: String = name
        protected set

    @OneToMany(mappedBy = "orderableVendorProduct", cascade = [CascadeType.ALL], orphanRemoval = true)
    protected val _orderableProductTemplateAssocs: MutableList<OrderableProductTemplateProductAssoc> = mutableListOf()

    fun addOrderableProductTemplateAssoc(assoc: OrderableProductTemplateProductAssoc) {
        _orderableProductTemplateAssocs.add(assoc)
    }
}
