
import com.google.gson.annotations.SerializedName


data class CatData (

  @SerializedName("fact"   ) var fact   : String? = null,
  @SerializedName("length" ) var length : Int?    = null

)