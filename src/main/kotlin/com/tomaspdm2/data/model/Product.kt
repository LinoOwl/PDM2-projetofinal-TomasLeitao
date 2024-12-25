package com.tomaspdm2.data.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Product(
    val name: String,
    val category: String,
    val price: String,
    @BsonId
    var id: String = ObjectId().toString()
)
//modelo dos itens na base de dados