package com.example.registrodesuperheroes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.registrodesuperheroes.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    /*THE OBJECTIVE IS TO CREATE KEYS FROM AVOIDING MISTAKES*/
    /*EL OBJETIVO ES CREAR LLAVES PARA EVITAR ERRORES*/
    companion object{
        const val SUPERHERO_KEY = "superhero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*WE MAKES REFERENCE OF THE BUILDING INTENTS "PUTEXTRA" CREATED IN ACTIVITY MAIN */
        /*HACEMOS REFERENCIA DE LOS PUT EXTRA QUE SE CREARON EN EL ACTIVITY MAIN*/

        /*USE PARCELABLES*/
        val bundle: Bundle = intent.extras!!
        val superhero: Superhero = bundle.getParcelable<Superhero>(SUPERHERO_KEY)!!

        /*WE REFERENCE THE ID'S BUILT IN DETAIL ACTIVITY BECAUSE THE INFORMATION WILL BE SAVED IN THEM*/
        /*HACEMOS REFERENCIA THE LOS ID CONSTRUIDOS EN EL DETAIL ACTIVITY PORQUE EN ELLOS SE GUARDARA
        LA INFORMACION QUE SE INTRODUJO EN MAIN ACTIVITY*/
        /*USE PARCELABLES*/
        /*binding.heroName.text = Superhero.name
        binding.alterEgoText.text = Superhero.alterEgo
        binding.shortBioText.text = Superhero.bio
        binding.levelPower.rating = Superhero.power*/

        binding.superhero = superhero

    }
}