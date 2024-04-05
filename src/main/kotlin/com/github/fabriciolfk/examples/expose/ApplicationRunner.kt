package com.github.fabriciolfk.examples.expose

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Component
@Transactional
class ApplicationRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        SchemaUtils.create(Orders, Customers)

        Orders.deleteAll()
        Customers.deleteAll()

        "Fabricio, Lucas, Suzana".split(",")
            .forEach {
                val name = it

                Customers
                    .insertAndGetId { it[Customers.name] = name }
            }

        val customerId = Customers
            .insertAndGetId { it[Customers.name] = "jacob" }

        setOf(UUID.randomUUID(), UUID.randomUUID())
            .map { it.toString() }
            .forEach {
                val uuid = it
                Orders.insert {
                    it[Orders.customerId] = customerId
                    it[Orders.sku] = uuid

                }

            }

        Customers.selectAll()
            .forEach { println(it[Customers.name]) }

        println("-----------------------------")

        val ordes = (Customers innerJoin Orders)
            .selectAll()
            .where{ Orders.customerId eq customerId}
            .map { Order(it[Orders.id].value, it[Orders.sku]) }

        val result = Customers.selectAll()
            .where {
                Customers.name eq "jacob"
            }.map { Customer(it[Customers.id].value, it[Customers.name], ordes) }
            .first()

        println(result)
    }
}


data class Customer(val id: Int, val name: String, val orders: List<Order> = emptyList())

data class Order(val id: Int, val sku: String)

object Customers : IntIdTable("customers") {
    val name = text("name")
}

object Orders : IntIdTable("orders") {
    val sku = text("sku")
    val customerId = reference("customers", Customers)
}