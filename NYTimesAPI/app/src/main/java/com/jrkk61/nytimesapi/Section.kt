package com.jrkk61.nytimesapi

import com.google.gson.annotations.SerializedName

class Section(

        @field:SerializedName("results")
        var results: List<ArticleM>)