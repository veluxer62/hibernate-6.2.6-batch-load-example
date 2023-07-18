package com.example.demo

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface OrderableVendorProductRepository : JpaRepository<OrderableVendorProduct, UUID>
