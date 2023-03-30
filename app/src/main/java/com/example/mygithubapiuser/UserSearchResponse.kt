package com.example.mygithubapiuser

import com.google.gson.annotations.SerializedName

data class UserSearchResponse(

	@field:SerializedName("total_count")
	val totalCount: Int? = null,

	@field:SerializedName("incomplete_results")
	val incompleteResults: Boolean? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class ItemsItem(

	@field:SerializedName("gists_url")
	val gistsUrl: String? = null,

	@field:SerializedName("repos_url")
	val reposUrl: String? = null,

	@field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("starred_url")
	val starredUrl: String? = null,

	@field:SerializedName("login")
	val login: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("subscriptions_url")
	val subscriptionsUrl: String? = null,

	@field:SerializedName("score")
	val score: Any? = null,

	@field:SerializedName("received_events_url")
	val receivedEventsUrl: String? = null,

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("events_url")
	val eventsUrl: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("site_admin")
	val siteAdmin: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("gravatar_id")
	val gravatarId: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null,

	@field:SerializedName("organizations_url")
	val organizationsUrl: String? = null
)

data class UserDetail (

	@SerializedName("login"               )
	var login             : String?  = null,

	@SerializedName("id"                  )
	var id                : Int?     = null,

	@SerializedName("node_id"             )
	var nodeId            : String?  = null,

	@SerializedName("avatar_url"          )
	var avatarUrl         : String?  = null,

	@SerializedName("gravatar_id"         )
	var gravatarId        : String?  = null,

	@SerializedName("url"                 )
	var url               : String?  = null,

	@SerializedName("html_url"            )
	var htmlUrl           : String?  = null,

	@SerializedName("followers_url"       )
	var followersUrl      : String?  = null,

	@SerializedName("following_url"       )
	var followingUrl      : String?  = null,

	@SerializedName("gists_url"           )
	var gistsUrl          : String?  = null,

	@SerializedName("starred_url"         )
	var starredUrl        : String?  = null,

	@SerializedName("subscriptions_url"   )
	var subscriptionsUrl  : String?  = null,

	@SerializedName("organizations_url"   )
	var organizationsUrl  : String?  = null,

	@SerializedName("repos_url"           )
	var reposUrl          : String?  = null,

	@SerializedName("events_url"          )
	var eventsUrl         : String?  = null,

	@SerializedName("received_events_url" )
	var receivedEventsUrl : String?  = null,

	@SerializedName("type"                )
	var type              : String?  = null,

	@SerializedName("site_admin"          )
	var siteAdmin         : Boolean? = null,

	@SerializedName("name"                )
	var name              : String?  = null,

	@SerializedName("company"             )
	var company           : String?  = null,

	@SerializedName("blog"                )
	var blog              : String?  = null,

	@SerializedName("location"            )
	var location          : String?  = null,

	@SerializedName("email"               )
	var email             : String?  = null,

	@SerializedName("hireable"            )
	var hireable          : String?  = null,

	@SerializedName("bio"                 )
	var bio               : String?  = null,

	@SerializedName("twitter_username"    )
	var twitterUsername   : String?  = null,

	@SerializedName("public_repos"        )
	var publicRepos       : Int?     = null,

	@SerializedName("public_gists"        )
	var publicGists       : Int?     = null,

	@SerializedName("followers"           )
	var followers         : Int?     = null,

	@SerializedName("following"           )
	var following         : Int?     = null,

	@SerializedName("created_at"          )
	var createdAt         : String?  = null,

	@SerializedName("updated_at"          )
	var updatedAt         : String?  = null

)
