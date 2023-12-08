package sw.sample.designpattern

data class ImageResponse(
    val id: String,
    val urls:urlRespones,
    val color:String
)

data class urlRespones(
    val raw: String,
    val full: String,
    val regular:String,
    val small : String,
    val thumb : String,
)
