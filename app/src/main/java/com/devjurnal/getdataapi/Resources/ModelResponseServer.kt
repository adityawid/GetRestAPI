package com.devjurnal.getdataapi.Resources

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ModelResponseServer (

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("title")
		val title: String? = null,

		@field:SerializedName("body")
		val body: String? = null,

		@field:SerializedName("userId")
		val userId: Int? = null


) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Int::class.java.classLoader) as Int?,
			source.readString(),
			source.readString(),
			source.readValue(Int::class.java.classLoader) as Int?
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(id)
		writeString(title)
		writeString(body)
		writeValue(userId)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<ModelResponseServer> = object : Parcelable.Creator<ModelResponseServer> {
			override fun createFromParcel(source: Parcel): ModelResponseServer = ModelResponseServer(source)
			override fun newArray(size: Int): Array<ModelResponseServer?> = arrayOfNulls(size)
		}
	}
}