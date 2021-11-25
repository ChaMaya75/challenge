package com.cml.challenge.data.model

class ProductProvider{
    companion object {

        fun getProduct(index:Int):ProductModel{
            return products[index]
        }

        private val products = listOf<ProductModel>(
            ProductModel(
                Body(
                    true,
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
                    "30 dias con el fabricante"
                ), 200
            ),
            ProductModel(
                Body(
                    true,
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
                    "30 dias con el fabricante"
                ), 200
            ),
            ProductModel(
                Body(
                    true,
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
                    "30 dias con el fabricante"
                ), 200
            )
        )
    }
}