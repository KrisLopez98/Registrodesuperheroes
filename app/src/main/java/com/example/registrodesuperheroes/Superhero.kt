package com.example.registrodesuperheroes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*IT'S USE PARCELABLE TO SYNTHESIZE CODE AND DON'T USE PUTEXTRA */
@Parcelize
class Superhero (val name: String, val alterEgo: String, val bio: String, val power: Float) :
    Parcelable