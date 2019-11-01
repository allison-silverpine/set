package com.example.set.models

import com.example.set.R

class Mapper{

    fun tagToResource(tag : String) : Int
    {
        when(tag){
            "one_hollow_blue_circle"   			-> return R.drawable.one_hollow_blue_circle
            "one_hollow_blue_diamond"  			-> return R.drawable.one_hollow_blue_diamond
            "one_hollow_blue_rectangle"			-> return R.drawable.one_hollow_blue_rectangle
            "one_hollow_green_circle"			-> return R.drawable.one_hollow_green_circle
            "one_hollow_green_diamond"			-> return R.drawable.one_hollow_green_diamond
            "one_hollow_green_rectangle"		-> return R.drawable.one_hollow_green_rectangle
            "one_hollow_orange_circle"			-> return R.drawable.one_hollow_orange_circle
            "one_hollow_orange_diamond"			-> return R.drawable.one_hollow_orange_diamond
            "one_hollow_orange_rectangle"		-> return R.drawable.one_hollow_orange_rectangle
            "one_solid_blue_circle"				-> return R.drawable.one_solid_blue_circle
            "one_solid_blue_diamond"			-> return R.drawable.one_solid_blue_diamond
            "one_solid_blue_rectangle"			-> return R.drawable.one_solid_blue_rectangle
            "one_solid_green_circle"			-> return R.drawable.one_solid_green_circle
            "one_solid_green_diamond"			-> return R.drawable.one_solid_green_diamond
            "one_solid_green_rectangle"			-> return R.drawable.one_solid_green_rectangle
            "one_solid_orange_circle"			-> return R.drawable.one_solid_orange_circle
            "one_solid_orange_diamond"			-> return R.drawable.one_solid_orange_diamond
            "one_solid_orange_rectangle"		-> return R.drawable.one_solid_orange_rectangle
            "one_striped_blue_circle"			-> return R.drawable.one_striped_blue_circle
            "one_striped_blue_diamond"			-> return R.drawable.one_striped_blue_diamond
            "one_striped_blue_rectangle"		-> return R.drawable.one_striped_blue_rectangle
            "one_striped_green_circle"			-> return R.drawable.one_striped_green_circle
            "one_striped_green_diamond"			-> return R.drawable.one_striped_green_diamond
            "one_striped_green_rectangle"		-> return R.drawable.one_striped_green_rectangle
            "one_striped_orange_circle"			-> return R.drawable.one_striped_orange_circle
            "one_striped_orange_diamond"		-> return R.drawable.one_striped_orange_diamond
            "one_striped_orange_rectangle"		-> return R.drawable.one_striped_orange_rectangle
            "six_hollow_blue_circle"			-> return R.drawable.six_hollow_blue_circle
            "six_hollow_blue_diamond"			-> return R.drawable.six_hollow_blue_diamond
            "six_hollow_blue_rectangle"			-> return R.drawable.six_hollow_blue_rectangle
            "six_hollow_green_circle"			-> return R.drawable.six_hollow_green_circle
            "six_hollow_green_diamond"			-> return R.drawable.six_hollow_green_diamond
            "six_hollow_green_rectangle"		-> return R.drawable.six_hollow_green_rectangle
            "six_hollow_orange_circle"			-> return R.drawable.six_hollow_orange_circle
            "six_hollow_orange_diamond"			-> return R.drawable.six_hollow_orange_diamond
            "six_hollow_orange_rectangle"		-> return R.drawable.six_hollow_orange_rectangle
            "six_solid_blue_circle"				-> return R.drawable.six_solid_blue_circle
            "six_solid_blue_diamond"			-> return R.drawable.six_solid_blue_diamond
            "six_solid_blue_rectangle"			-> return R.drawable.six_solid_blue_rectangle
            "six_solid_green_circle"			-> return R.drawable.six_solid_green_circle
            "six_solid_green_diamond"			-> return R.drawable.six_solid_green_diamond
            "six_solid_green_rectangle"			-> return R.drawable.six_solid_green_rectangle
            "six_solid_orange_circle"			-> return R.drawable.six_solid_orange_circle
            "six_solid_orange_diamond"			-> return R.drawable.six_solid_orange_diamond
            "six_solid_orange_rectangle"		-> return R.drawable.six_solid_orange_rectangle
            "six_striped_blue_circle"			-> return R.drawable.six_striped_blue_circle
            "six_striped_blue_diamond"			-> return R.drawable.six_striped_blue_diamond
            "six_striped_blue_rectangle"		-> return R.drawable.six_striped_blue_rectangle
            "six_striped_green_circle"			-> return R.drawable.six_striped_green_circle
            "six_striped_green_diamond"			-> return R.drawable.six_striped_green_diamond
            "six_striped_green_rectangle"		-> return R.drawable.six_striped_green_rectangle
            "six_striped_orange_circle"			-> return R.drawable.six_striped_orange_circle
            "six_striped_orange_diamond"		-> return R.drawable.six_striped_orange_diamond
            "six_striped_orange_rectangle"		-> return R.drawable.six_striped_orange_rectangle
            "three_hollow_blue_circle"			-> return R.drawable.three_hollow_blue_circle
            "three_hollow_blue_diamond"			-> return R.drawable.three_hollow_blue_diamond
            "three_hollow_blue_rectangle"		-> return R.drawable.three_hollow_blue_rectangle
            "three_hollow_green_circle"			-> return R.drawable.three_hollow_green_circle
            "three_hollow_green_diamond"		-> return R.drawable.three_hollow_green_diamond
            "three_hollow_green_rectangle"		-> return R.drawable.three_hollow_green_rectangle
            "three_hollow_orange_circle"		-> return R.drawable.three_hollow_orange_circle
            "three_hollow_orange_diamond"		-> return R.drawable.three_hollow_orange_diamond
            "three_hollow_orange_rectangle"		-> return R.drawable.three_hollow_orange_rectangle
            "three_solid_blue_circle"			-> return R.drawable.three_solid_blue_circle
            "three_solid_blue_diamond"			-> return R.drawable.three_solid_blue_diamond
            "three_solid_blue_rectangle"		-> return R.drawable.three_solid_blue_rectangle
            "three_solid_green_circle"			-> return R.drawable.three_solid_green_circle
            "three_solid_green_diamond"			-> return R.drawable.three_solid_green_diamond
            "three_solid_green_rectangle"		-> return R.drawable.three_solid_green_rectangle
            "three_solid_orange_circle"			-> return R.drawable.three_solid_orange_circle
            "three_solid_orange_diamond"		-> return R.drawable.three_solid_orange_diamond
            "three_solid_orange_rectangle"		-> return R.drawable.three_solid_orange_rectangle
            "three_striped_blue_circle"			-> return R.drawable.three_striped_blue_circle
            "three_striped_blue_diamond"		-> return R.drawable.three_striped_blue_diamond
            "three_striped_blue_rectangle"		-> return R.drawable.three_striped_blue_rectangle
            "three_striped_green_circle"		-> return R.drawable.three_striped_green_circle
            "three_striped_green_diamond"		-> return R.drawable.three_striped_green_diamond
            "three_striped_green_rectangle"		-> return R.drawable.three_striped_green_rectangle
            "three_striped_orange_circle"		-> return R.drawable.three_striped_orange_circle
            "three_striped_orange_diamond"		-> return R.drawable.three_striped_orange_diamond
            "three_striped_orange_rectangle"	-> return R.drawable.three_striped_orange_rectangle
        }
        return R.drawable.empty
    }
}