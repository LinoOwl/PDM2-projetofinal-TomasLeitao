package com.tomaspdm2.data

import com.mongodb.ConnectionString
import com.tomaspdm2.data.model.Product
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

private val client =
    org.litote.kmongo.KMongo.createClient(ConnectionString("mongodb+srv://tomasleitao860:NSgz1jKySRpYEY97@clusterpdm2-2024.hmt9o.mongodb.net/?retryWrites=true&w=majority&appName=Clusterpdm2-2024"))
private val database = client.getDatabase("CompanyDatabase")
private val products = database.getCollection<Product>("Products")



 fun getProductById(id: String): Product? {
    return products.findOneById(id)
}
//metodo que recebe o "produto" da base de dados através do ID

 fun createOrUpdateProductsById(product: Product): Boolean {
    val productsExists = products.findOneById(product.id) != null
    return if (productsExists) {
        products.updateOneById(product.id, product).wasAcknowledged()
    } else {
        product.id = ObjectId().toString()
        products.insertOne(product).wasAcknowledged()
    }
}
//metodo que cria um produto quando não tem ID ou altera um produto que já tenha um ID


 fun deleteProductById(employeeId: String): Boolean {
    val product = products.findOne(Product::id eq employeeId)
    product?.let { employee ->
        return products.deleteOneById(employee.id).wasAcknowledged()
    } ?: return false

}
//metodo que elimina o "produto" da base de dados através do ID

