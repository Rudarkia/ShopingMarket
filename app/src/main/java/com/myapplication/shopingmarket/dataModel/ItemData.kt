package com.myapplication.shopingmarket.dataModel

class ItemData {
    /**Set Data**/
//    var id: String?= null
    var category: String?= null
    var current_score: Float? = null
    var description: String?= null
    var discontinued: Boolean? = null
    var image: String?= null
    var max_quantity: Float? = null
    var price: Float? = null
    var stock: Float? = null
    var title_en: String?= null
    var title_es: String?= null

    constructor(){}
        constructor(
//            id:String?,
            category: String?,
            discontinued: Boolean?,
            image: String?,
            title_en: String?,
            title_es: String?,
            price: Float?,
            max_quantity: Float?,
            stock: Float?,
            current_score: Float?,
            description: String?
        ){
//            this.id = id
            this.category = category
            this.discontinued = discontinued
            this.image = image
            this.title_en = title_en
            this.title_es = title_es
            this.price = price
            this.max_quantity = max_quantity
            this.stock = stock
            this.current_score = current_score
            this.description = description
        }

}