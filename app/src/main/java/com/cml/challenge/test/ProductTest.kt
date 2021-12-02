package com.cml.challenge.test

import com.cml.challenge.core.data.ProductDataSource
import com.cml.challenge.core.model.DetailModel
import com.cml.challenge.core.model.Picture
import com.cml.challenge.core.model.ProductModel
import com.cml.challenge.core.model.Shipping

class ProductTest : ProductDataSource {
    override suspend fun getAllProducts(query: String): List<ProductModel>? {
        val lstProducts = mutableListOf<ProductModel>()

        lstProducts.add(ProductModel("MLM833251578",
            "https://www.mercadolibre.com.mx/nintendo-switch-32gb-standard-gris-y-negro/p/MLM8755484",
            8299.0,
            "http://mlm-s1-p.mlstatic.com/799580-MLA40692342178_022020-I.jpg",
            "Nintendo Switch 32gb Standard Gris Y Negro"))

        lstProducts.add(ProductModel("MLM833251578",
            "https://www.mercadolibre.com.mx/nintendo-switch-32gb-standard-gris-y-negro/p/MLM8755484",
            8299.0,
            "http://mlm-s1-p.mlstatic.com/799580-MLA40692342178_022020-I.jpg",
            "Nintendo Switch 32gb Standard Gris Y Negro"))

        lstProducts.add(ProductModel("MLM833251578",
            "https://www.mercadolibre.com.mx/nintendo-switch-32gb-standard-gris-y-negro/p/MLM8755484",
            8299.0,
            "http://mlm-s1-p.mlstatic.com/799580-MLA40692342178_022020-I.jpg",
            "Nintendo Switch 32gb Standard Gris Y Negro"))

        return lstProducts
    }

    override suspend fun getDetailProduct(query: String): DetailModel? {

        /*val detalProduct = DetailModel(        true,
            5,
            "new",
            "MLM833251578",
            "https://www.mercadolibre.com.mx/nintendo-switch-32gb-standard-gris-y-negro/p/MLM8755484",
            arrayListOf(
                Picture("https://mlm-s1-p.mlstatic.com/799580-MLA40692342178_022020-O.jpg"),
                Picture("https://mlm-s1-p.mlstatic.com/606867-MLA40692089529_022020-O.jpg")
            ),
            8299.0,
            Shipping(true, false),
            34,
            "http://mlm-s1-p.mlstatic.com/799580-MLA40692342178_022020-I.jpg",
            "Nintendo Switch 32gb Standard Gris Y Negro",
            "30 dias con el fabricante")*/


        return null
    }
}