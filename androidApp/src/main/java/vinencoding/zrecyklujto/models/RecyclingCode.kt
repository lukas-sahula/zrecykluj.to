package vinencoding.zrecyklujto.models

import android.os.Parcel
import android.os.Parcelable

data class RecyclingCode (
    val number: String = "",
    val code: String = "",
    val title: String = "",
    val throwInto: String = "",
    val materialType: String = ""
): Parcelable {
    constructor(source: Parcel): this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )
    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(number)
        writeString(code)
        writeString(title)
        writeString(throwInto)
        writeString(materialType)
    }

    companion object CREATOR : Parcelable.Creator<RecyclingCode> {
        override fun createFromParcel(parcel: Parcel): RecyclingCode {
            return RecyclingCode(parcel)
        }

        override fun newArray(size: Int): Array<RecyclingCode?> {
            return arrayOfNulls(size)
        }
    }
}
