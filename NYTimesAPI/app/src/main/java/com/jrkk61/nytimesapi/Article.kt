package com.jrkk61.nytimesapi

import com.google.gson.annotations.SerializedName

class Article(

        @field:SerializedName("multimedia")
        var multimedia: List<Multimedia>)

