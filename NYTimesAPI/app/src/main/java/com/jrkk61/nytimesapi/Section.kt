package com.jrkk61.nytimesapi

import com.google.gson.annotations.SerializedName

class Section(

        var num_results: Int,
        @field:SerializedName("results")
        var results: List<Article>)