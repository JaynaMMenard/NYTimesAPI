<<<<<<< HEAD
package com.jrkk61.nytimesapi

import com.google.gson.annotations.SerializedName

class Section(

        @field:SerializedName("results")
        var results: List<ArticleM>)
=======
package com.jrkk61.nytimesapi

import com.google.gson.annotations.SerializedName

class Section(

        var num_results: Int,
        @field:SerializedName("results")
        var results: List<Article>)
>>>>>>> e301c2208c3ed350042d9d4a6b36d339dcd01603
