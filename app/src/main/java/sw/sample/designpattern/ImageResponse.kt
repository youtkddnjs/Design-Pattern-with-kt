package sw.sample.designpattern

data class ImageResponse(
    val id: String,
    val urls:UrlRespones,
    val color:String
)

data class UrlRespones(
    val raw: String,
    val full: String,
    val regular:String,
    val small : String,
    val thumb : String,
)
