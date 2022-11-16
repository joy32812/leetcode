
data class Video(val creator: String, val id: String, val view: Long)

fun mostPopularCreator(creators: Array<String>, ids: Array<String>, views: IntArray): List<List<String>> {

    val videos = creators.indices.map { Video(creators[it], ids[it], views[it].toLong()) }

    val maxViewMap = mutableMapOf<String, Video>()
    for (v in videos) {
        val maxView = maxViewMap[v.creator]
        if (maxView == null || maxView.view < v.view || (maxView.view == v.view && maxView.id > v.id)) {
            maxViewMap[v.creator] = v
        }
    }

    val popularMap =
        videos.groupBy { it.creator }
            .mapValues { it.value.map { it.view }.sum() }

    val maxViews = popularMap.values.maxOrNull()!!

    val popularCreators = popularMap.filter { it.value == maxViews }.keys.toList()

    return popularCreators.map { c ->
        listOf(c, maxViewMap[c]!!.id)
    }


}
