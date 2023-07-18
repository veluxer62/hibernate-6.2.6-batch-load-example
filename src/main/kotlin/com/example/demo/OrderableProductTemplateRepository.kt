package com.example.demo

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface OrderableProductTemplateRepository : JpaRepository<OrderableProductTemplate, UUID>
