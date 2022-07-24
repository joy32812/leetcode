import java.util.*

/**
 * TreeMap && TreeSet.
 * Be ware: remove the key if the value is empty.
 */
class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    data class FoodRating(val food: String, val cuisine: String, val rating: Int)
    val cuisineMap = mutableMapOf<String, TreeMap<Int, TreeSet<String>>>()

    val foodMap = mutableMapOf<String, FoodRating>()

    init {
        for (i in foods.indices) {
            val fr = FoodRating(foods[i], cuisines[i], ratings[i])
            cuisineMap.getOrPut(fr.cuisine) { TreeMap() }.getOrPut(fr.rating) { TreeSet() }.add(fr.food)

            foodMap[fr.food] = fr
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val oldFr = foodMap[food]!!
        cuisineMap[oldFr.cuisine]!![oldFr.rating]!!.remove(food)

        if (cuisineMap[oldFr.cuisine]!![oldFr.rating]!!.isEmpty()) {
            cuisineMap[oldFr.cuisine]!!.remove(oldFr.rating)
        }

        val newFr = FoodRating(food, oldFr.cuisine, newRating)
        cuisineMap[newFr.cuisine]!!.getOrPut(newFr.rating) { TreeSet() }.add(food)

        foodMap[food] = newFr
    }

    fun highestRated(cuisine: String): String {
        return cuisineMap[cuisine]!!.lastEntry().value.first()
    }

}

//["FoodRatings","changeRating","highestRated","changeRating","changeRating","changeRating","highestRated","highestRated"]
//,["qnvseohnoe",11],["fajbervsj"],["emgqdbo",3],["jmvfxjohq",9],["emgqdbo",14],["fajbervsj"],["snaxol"]]
fun main() {
    val obj = FoodRatings(

        arrayOf("emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"),
        arrayOf("snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"),
        intArrayOf(2, 6, 18, 6, 5)
    )

    obj.changeRating("qnvseohnoe", 11)
    println(obj.highestRated("fajbervsj"))
    obj.changeRating("emgqdbo", 3)
    obj.changeRating("jmvfxjohq", 9)
    obj.changeRating("emgqdbo", 14)
    println(obj.highestRated("fajbervsj"))
    println(obj.highestRated("snaxol"))


}
