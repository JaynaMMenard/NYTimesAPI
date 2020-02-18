package com.jrkk61.nytimesapi

import com.google.gson.annotations.SerializedName

class ArticleM(

        var title: String,
        @field:SerializedName("abstract")
        var abstract: String,
        @field:SerializedName("multimedia")
        var multimedia: List<MultimediaM>)

