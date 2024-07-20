package com.example.apiCalling
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("applied_campaign")
    val applied_campaign: Int,
    @SerializedName("data")
    val data: Data,
    @SerializedName("extra_income")
    val extra_income: Double,
    @SerializedName("links_created_today")
    val links_created_today: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("startTime")
    val startTime: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("support_whatsapp_number")
    val support_whatsapp_number: String,
    @SerializedName("today_clicks")
    val today_clicks: Int,
    @SerializedName("top_location")
    val topLocation: String,
    @SerializedName("top_source")
    val top_source: String,
    @SerializedName("total_clicks")
    val total_clicks: Int,
    @SerializedName("total_links")
    val total_links: Int
)

data class Data(
    @SerializedName("favourite_links")
    val favourite_links: List<Any>,
    @SerializedName("overall_url_chart")
    val overall_url_chart: OverallUrlChart,
    @SerializedName("recent_links")
    val recent_links: List<RecentLink>,
    @SerializedName("top_links")
    val top_links: List<TopLink>
)

data class OverallUrlChart(
    @SerializedName("00:00")
    val x0000: Int,
    @SerializedName("01:00")
    val x0100: Int,
    @SerializedName("02:00")
    val x0200: Int,
    @SerializedName("03:00")
    val x0300: Int,
    @SerializedName("04:00")
    val x0400: Int,
    @SerializedName("05:00")
    val x0500: Int,
    @SerializedName("06:00")
    val x0600: Int,
    @SerializedName("07:00")
    val x0700: Int,
    @SerializedName("08:00")
    val x0800: Int,
    @SerializedName("09:00")
    val x0900: Int,
    @SerializedName("10:00")
    val x1000: Int,
    @SerializedName("11:00")
    val x1100: Int,
    @SerializedName("12:00")
    val x1200: Int,
    @SerializedName("13:00")
    val x1300: Int,
    @SerializedName("14:00")
    val x1400: Int,
    @SerializedName("15:00")
    val x1500: Int,
    @SerializedName("16:00")
    val x1600: Int,
    @SerializedName("17:00")
    val x1700: Int,
    @SerializedName("18:00")
    val x1800: Int,
    @SerializedName("19:00")
    val x1900: Int,
    @SerializedName("20:00")
    val x2000: Int,
    @SerializedName("21:00")
    val x2100: Int,
    @SerializedName("22:00")
    val x2200: Int,
    @SerializedName("23:00")
    val x2300: Int
)

data class RecentLink(
    @SerializedName("app")
    val app: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("is_favourite")
    val isFavourite: Boolean,
    @SerializedName("original_image")
    val originalImage: String,
    @SerializedName("smart_link")
    val smartLink: String,
    @SerializedName("thumbnail")
    val thumbnail: Any,
    @SerializedName("times_ago")
    val timesAgo: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("total_clicks")
    val totalClicks: Int,
    @SerializedName("url_id")
    val urlId: Int,
    @SerializedName("url_prefix")
    val urlPrefix: Any,
    @SerializedName("url_suffix")
    val urlSuffix: String,
    @SerializedName("web_link")
    val webLink: String
)


data class TopLink(
    @SerializedName("app")
    val app: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("is_favourite")
    val isFavourite: Boolean,
    @SerializedName("original_image")
    val originalImage: String,
    @SerializedName("smart_link")
    val smartLink: String,
    @SerializedName("thumbnail")
    val thumbnail: Any,
    @SerializedName("times_ago")
    val timesAgo: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("total_clicks")
    val totalClicks: Int,
    @SerializedName("url_id")
    val url_id: Int,
    @SerializedName("url_prefix")
    val url_prefix: String,
    @SerializedName("url_suffix")
    val url_suffix: String,
    @SerializedName("web_link")
    val web_link: String
)