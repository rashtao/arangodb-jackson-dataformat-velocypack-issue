package com.example.issue

import com.arangodb.VelocyJack
import com.fasterxml.jackson.module.kotlin.KotlinModule

data class Record(
        val _key: String,
        val _rev: String,
        val _id: String,
        val title: String,
        val answer: Int
)

fun main() {

    val serializer = VelocyJack().apply { configure { it.registerModule(KotlinModule()) } }
    val serialized = serializer.serialize(Record(_rev = "_rev", _key = "_key", _id = "_id", answer = 0, title = "title"))
    val deserialized = serializer.deserialize<Record>(serialized, Record::class.java)

    println(serialized)
    println(deserialized)

}
