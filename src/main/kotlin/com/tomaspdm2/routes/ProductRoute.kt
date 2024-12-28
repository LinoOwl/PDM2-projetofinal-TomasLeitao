package com.tomaspdm2.routes

import com.tomaspdm2.data.SimpleResponse
import com.tomaspdm2.data.createOrUpdateProductsById
import com.tomaspdm2.data.deleteProductById
import com.tomaspdm2.data.getProductById
import com.tomaspdm2.data.model.Product
import com.tomaspdm2.data.requests.DeleteProductRequest
import com.tomaspdm2.data.requests.ProductRequest
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//routes para testar a API usando o POSTMAN
fun Route.productRoutes() {
    route("/get-product") {
        get {
            val productId = call.receive<ProductRequest>().id
            val product = getProductById(productId)
            product?.let {
                call.respond(
                    HttpStatusCode.OK,
                    SimpleResponse(true, "Product successfully retrieved", it)
                )
            } ?: call.respond(
                HttpStatusCode.OK,
                SimpleResponse(true, "There is no product with this id", Unit)

            )

        }
    }

    route("/create-update-product") {
        post {
            val request = try {
                call.receive<Product>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (createOrUpdateProductsById(request)) {
                call.respond(
                    HttpStatusCode.OK,
                    SimpleResponse(true, "Product successfully created/updated", Unit)

                )
            } else {
                call.respond(HttpStatusCode.Conflict)
            }
        }
    }

    route("/delete-product") {
        post {
            val request = try {
                call.receive<DeleteProductRequest>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (deleteProductById(request.id)) {
                call.respond(
                    HttpStatusCode.OK,
                    SimpleResponse(true, "Product successfully deleted", Unit)
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    SimpleResponse(true, "Product not found", Unit)
                )
            }
        }
    }


}